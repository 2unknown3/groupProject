package com.example.harta;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MainFragment extends Fragment {

    private static final String TAG = "bluetooth2";
    private final String DEVICE_ADDRESS="98:D3:61:FD:43:5D";
    private final UUID PORT_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");//Serial Port Service ID
    private BluetoothAdapter btAdapter;
    private BluetoothSocket btSocket;

    final int SEND_SMS_PERMISSION_REQUEST_CODE = 1;
    final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    StringBuilder sb = new StringBuilder();
    //private StringBuilder sb = new StringBuilder();

    private ConnectedThread mConnectedThread;

    private volatile boolean stopThread = false;

    static final int STATE_MESSAGE_RECEIVED = 1;
    int REQUEST_ENABLE_BLUETOOTH = 1;
    String currentDate;
    private int avg =1, counter=1, fAvg=0, maxiBpm=1 , miniBpm=200;
    TextView textView, avgBpm, targetBpm, bpmStatus, maximumBpm, minimumBpm;
    Button startBtn, pauseBtn, saveBtn;
    Handler h, h2, maxHandler, minHandler;
    DatabaseHelper myDB;
    Cursor cursor;
    int highBpm=0, lowBpm=0;
    String smsMsg = "", currLocation ="";

    @SuppressLint("HandlerLeak")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);

        textView = view.findViewById(R.id.bpm);
        avgBpm = view.findViewById(R.id.avgBpm);
        startBtn = view.findViewById(R.id.startButton);
        pauseBtn = view.findViewById(R.id.pauseButton);
        saveBtn = view.findViewById(R.id.saveButton);
        targetBpm = view.findViewById(R.id.targetBpm);
        bpmStatus = view.findViewById(R.id.bpmStatus);
        maximumBpm = view.findViewById(R.id.maxBpm);
        minimumBpm = view.findViewById(R.id.minBpm);
        saveBtn.setEnabled(false);



        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        currentDate = simpleDateFormat.format(calendar.getTime());

        myDB = new DatabaseHelper(getContext());
        cursor = myDB.getListContent();
        cursor.moveToNext();
       // targetBpm.setText(cursor.getString(2));
        checkBpmStatus();
        checkTargetBpm();
        implementListeners();

        h2 = new Handler();
        maxHandler = new Handler();
        minHandler = new Handler();
     //   maxHandler = new Handler();
     //   minHandler = new Handler();
        h = new Handler(){
            @SuppressLint("SetTextI18n")
            public void handleMessage(android.os.Message msg){

                switch (msg.what){
                    case STATE_MESSAGE_RECEIVED:
                        byte[] readBuff = (byte[]) msg.obj;
                        String strIncom = new String(readBuff, 0, msg.arg1);                 // create string from bytes array
                        sb.append(strIncom);                                                // append string
                        int endOfLineIndex = sb.indexOf("\r\n");                            // determine the end-of-line
                        if (endOfLineIndex > 0) {                                            // if end-of-line,
                            String sbPrint = sb.substring(0, endOfLineIndex);               // extract string
                            sb.delete(0, sb.length());                                      // and clear
                            textView.setText(sbPrint);            // update TextView
                            int i = Integer.parseInt(sbPrint);
                            if(maxiBpm < i){
                                maxiBpm = i;
                                maximumBpm.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        maximumBpm.setText(String.valueOf(maxiBpm));
                                    }
                                });
                            }
                            if (miniBpm > i){
                                miniBpm = i;
                                minimumBpm.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        minimumBpm.setText(String.valueOf(miniBpm));
                                    }
                                });
                            }
                            avg += i;
                            fAvg = avg / counter;
                            avgBpm.setText(String.valueOf(fAvg));
                            counter++;

                        }
                        break;
                }
            }
        };




        btAdapter = BluetoothAdapter.getDefaultAdapter();

        return view;
    }


    private BluetoothSocket createBluetoothSocket(BluetoothDevice device) throws IOException {
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
            try {
                final Method m = device.getClass().getMethod("createInsecureRfcommSocketToServiceRecord", new Class[]{UUID.class});
                return (BluetoothSocket) m.invoke(device, PORT_UUID);
            } catch (Exception e) {
                Log.e(TAG, "Could not create Insecure RFComm Connection",e);
            }
        }
        return  device.createRfcommSocketToServiceRecord(PORT_UUID);
    }

    public void onResume() {
        super.onResume();

        Log.d(TAG, "...onResume - try connect...");

        // Set up a pointer to the remote node using it's address.
        BluetoothDevice device = btAdapter.getRemoteDevice(DEVICE_ADDRESS);

        // Two things are needed to make a connection:
        //   A MAC address, which we got above.
        //   A Service ID or UUID.  In this case we are using the
        //     UUID for SPP.

        try {
            btSocket = createBluetoothSocket(device);
        } catch (IOException e) {
            Log.d("Fatal Error", "In onResume() and socket create failed: " + e.getMessage() + ".");
        }

        // Discovery is resource intensive.  Make sure it isn't going on
        // when you attempt to connect and pass your message.
        btAdapter.cancelDiscovery();

        // Establish the connection.  This will block until it connects.
        Log.d(TAG, "...Connecting...");
        try {
            btSocket.connect();
            Log.d(TAG, "....Connection ok...");
        } catch (IOException e) {
            try {
                btSocket.close();
            } catch (IOException e2) {
                Log.d("Fatal Error", "In onResume() and unable to close socket during connection failure" + e2.getMessage() + ".");
            }
        }

        // Create a data stream so we can talk to server.
        Log.d(TAG, "...Create Socket...");

        mConnectedThread = new ConnectedThread(btSocket);
        mConnectedThread.start();
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d(TAG, "...In onPause()...");

        try     {
            btSocket.close();
        } catch (IOException e2) {
            Log.d("Fatal Error", "In onPause() and failed to close socket." + e2.getMessage() + ".");
        }
    }


    public void sendSignal(){
        cursor = myDB.getListContent();
        cursor.moveToNext();
        final int age = Integer.parseInt(cursor.getString(2));
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(stopThread){
                        return;
                    }
                    else {
                        try {
                            Thread.sleep(2000);
                            mConnectedThread.write("b");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(age >= 20 && age <= 29){
                            if(fAvg >= 100 && fAvg <= 170){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("NORMAL");
                                    }
                                });
                            }
                            else if(fAvg < 100){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too Low!");
                                        lowBpm++;
                                    }
                                });
                            }
                            else if(fAvg > 170){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too High!");
                                        highBpm++;
                                    }
                                });
                            }
                        }
                        else if(age >= 30 && age <= 34){
                            if(fAvg >= 95 && fAvg <= 162){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("NORMAL");
                                    }
                                });
                            }
                            else if(fAvg < 95){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too Low!");
                                        lowBpm++;
                                    }
                                });
                            }
                            else if(fAvg > 162){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too High!");
                                        highBpm++;
                                    }
                                });
                            }
                        }
                        else if(age >= 35 && age <= 39){
                            if(fAvg >= 93 && fAvg <= 157){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("NORMAL");
                                    }
                                });
                            }
                            else if(fAvg < 93){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too Low!");
                                        lowBpm++;
                                    }
                                });
                            }
                            else if(fAvg > 157){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too High!");
                                        highBpm++;
                                    }
                                });
                            }
                        }
                        else if(age >= 40 && age <= 44){
                            if(fAvg >= 90 && fAvg <= 153){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("NORMAL");
                                    }
                                });
                            }
                            else if(fAvg < 90){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too Low!");
                                        lowBpm++;
                                    }
                                });
                            }
                            else if(fAvg > 153){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too High!");
                                        highBpm++;
                                    }
                                });
                            }
                        }
                        else if(age >= 45 && age <= 49){
                            if(fAvg >= 88 && fAvg <= 149){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("NORMAL");
                                    }
                                });
                            }
                            else if(fAvg < 88){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too Low!");
                                        lowBpm++;
                                    }
                                });
                            }
                            else if(fAvg > 149){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too High!");
                                        highBpm++;
                                    }
                                });
                            }
                        }
                        else if(age >= 50 && age <= 54){
                            if(fAvg >= 85 && fAvg <= 145){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("NORMAL");
                                    }
                                });
                            }
                            else if(fAvg < 85){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too Low!");
                                        lowBpm++;
                                    }
                                });
                            }
                            else if(fAvg > 145){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too High!");
                                        highBpm++;
                                    }
                                });
                            }
                        }
                        else if(age >= 55 && age <= 59){
                            if(fAvg >= 83 && fAvg <= 140){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("NORMAL");
                                    }
                                });
                            }
                            else if(fAvg < 83){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too Low!");
                                        lowBpm++;
                                    }
                                });
                            }
                            else if(fAvg > 140){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too High!");
                                        highBpm++;
                                    }
                                });
                            }
                        }
                        else if(age >= 60 && age <= 64){
                            if(fAvg >= 80 && fAvg <= 136){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("NORMAL");
                                    }
                                });
                            }
                            else if(fAvg < 80){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too Low!");
                                        lowBpm++;
                                    }
                                });
                            }
                            else if(fAvg > 136){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too High!");
                                        highBpm++;
                                    }
                                });
                            }
                        }
                        else if(age >= 65 && age <= 69){
                            if(fAvg >= 78 && fAvg <= 132){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("NORMAL");
                                    }
                                });
                            }
                            else if(fAvg < 78){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too Low!");
                                        lowBpm++;
                                    }
                                });
                            }
                            else if(fAvg > 132){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too High!");
                                        highBpm++;
                                    }
                                });
                            }
                        }
                        else if(age >= 70){
                            if(fAvg >= 75 && fAvg <= 128){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("NORMAL");
                                    }
                                });
                            }
                            else if(fAvg < 75){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too Low!");
                                        lowBpm++;
                                    }
                                });
                            }
                            else if(fAvg > 128){
                                h2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bpmStatus.setText("Too High!");
                                        highBpm++;
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }).start();
    }

    public void  sendSms(String msg){

        String phone = cursor.getString(3);

        if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_PERMISSION_REQUEST_CODE);
        }
        else{
            getCurrentLocation();
        }

        if(checkSmsPermission(Manifest.permission.SEND_SMS)){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phone,null,msg + " "+ currLocation,null,null);
            Toast.makeText(getContext(),"Message Sent!", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getContext(),"Permission Denied!", Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == LOCATION_PERMISSION_REQUEST_CODE && grantResults.length > 0){
            getCurrentLocation();
        }
        else {
            Toast.makeText(getContext(),"Permission Denied!",Toast.LENGTH_LONG).show();
        }
    }

    public void getCurrentLocation(){

        final LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationServices.getFusedLocationProviderClient(getActivity()).requestLocationUpdates(locationRequest, new LocationCallback(){
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                LocationServices.getFusedLocationProviderClient(getActivity()).removeLocationUpdates(this);
                if(locationResult != null && locationResult.getLocations().size() > 0){
                    int latestLocationIndex = locationResult.getLocations().size() - 1;
                    double lat = locationResult.getLocations().get(latestLocationIndex).getLatitude();
                    double lon = locationResult.getLocations().get(latestLocationIndex).getLongitude();
                    currLocation = String.format("Latitude: %s\nLongitude: %s",lat,lon);
                }
            }
        }, Looper.getMainLooper());

    }

    public boolean checkSmsPermission(String permission){
        int check = ContextCompat.checkSelfPermission(getContext(),permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }
    private void checkBpmStatus() {
        cursor = myDB.getListContent();
        cursor.moveToNext();
        final int age = Integer.parseInt(cursor.getString(2));
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        thread2.start();

    }
    public void checkTargetBpm(){
        cursor = myDB.getListContent();
        cursor.moveToNext();
        final int age = Integer.parseInt(cursor.getString(2));
        if(age >= 20 && age <= 29){
            targetBpm.setText("100 - 170");
        }
        else if(age >= 30 && age <= 34){
            targetBpm.setText("95 - 162");
        }
        else if(age >= 35 && age <= 39){
            targetBpm.setText("93 - 157");
        }
        else if(age >= 40 && age <= 44){
            targetBpm.setText("90 - 153");
        }
        else if(age >= 45 && age <= 49){
            targetBpm.setText("88 - 149");
        }
        else if(age >= 50 && age <= 54){
            targetBpm.setText("85 - 145");
        }
        else if(age >= 55 && age <= 59){
            targetBpm.setText("83 - 140");
        }
        else if(age >= 60 && age <= 64){
            targetBpm.setText("80 - 136");
        }
        else if(age >= 65 && age <= 69){
            targetBpm.setText("78 - 132");
        }
        else if(age >= 70){
            targetBpm.setText("75 - 128");
        }
    }

    private class ConnectedThread extends Thread {
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThread(BluetoothSocket socket) {
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            // Get the input and output streams, using temp objects because
            // member streams are final
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) { }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {
            byte[] buffer = new byte[1024];  // buffer store for the stream
            int bytes; // bytes returned from read()

            // Keep listening to the InputStream until an exception occurs
            while (true) {
                try {
                    if(highBpm > 5){
                        maxHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                smsMsg = "Your Friend is Experiencing HIGH BPM. Check him/her now!";
                                sendSms(smsMsg);
                            }
                        });
                    }
                    if(lowBpm > 5){
                        maxHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                smsMsg = "Your Friend is Experiencing LOW BPM. Check him/her now!";
                                sendSms(smsMsg);
                            }
                        });
                    }
                    // Read from the InputStream
                    bytes = mmInStream.read(buffer);        // Get number of bytes and message in "buffer"
                    h.obtainMessage(STATE_MESSAGE_RECEIVED, bytes, -1, buffer).sendToTarget();     // Send to message queue Handler
               //     h2.obtainMessage(STATE_MESSAGE_RECEIVED, bytes, -1, buffer).sendToTarget();
                } catch (IOException e) {
                    break;
                }
            }
        }

        /* Call this from the main activity to send data to the remote device */
        public void write(String message) {
            Log.d(TAG, "...Data to send: " + message + "...");
            byte[] msgBuffer = message.getBytes();
            try {
                mmOutStream.write(msgBuffer);
            } catch (IOException e) {
                Log.d(TAG, "...Error data send: " + e.getMessage() + "...");
            }
        }


    }

    public void AddData(int avg, int max, int min, String dt){
        boolean insertData = myDB.addPulseData(avg,max,min,dt);

        if(insertData){
            Toast.makeText(getContext(),"Update Successfully!", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getContext(),"Something Went Wrong2!", Toast.LENGTH_LONG).show();
        }
    }


    private void implementListeners() {

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopThread = false;
                startBtn.setEnabled(false);
                sendSignal();
              //  checkBpmStatus();
            //    Intent serviceIntent = new Intent(getContext(), ExampleService.class);
            //    serviceIntent.putExtra("inputExtra", "TEST101");
             //   ContextCompat.startForegroundService(getContext(),serviceIntent);
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBtn.setEnabled(true);
                saveBtn.setEnabled(true);
                stopThread = true;

            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBtn.setEnabled(false);
              //  Toast.makeText(getContext(),"Avg: "+fAvg+" Max: "+maxiBpm+" Min: "+miniBpm+ " DT: "+currentDate, Toast.LENGTH_LONG).show();
                AddData(fAvg,maxiBpm,miniBpm,currentDate);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
