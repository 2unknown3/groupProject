package com.example.harta;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ScanDevice extends Fragment implements AdapterView.OnItemClickListener{

    private BluetoothAdapter mBluetoothAdapter;


    TextView btStatus;
    ListView listDevices;
    private Button scanButton, listenButton;
    Button btnEnableDisable_Discoverable, btnONOFF, btnDiscover;

    public ArrayList<BluetoothDevice> mBTDevices = new ArrayList<>();

    public DeviceListAdapter mDeviceListAdapter;

    private final BroadcastReceiver mBroadcastReceiver1 = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            // When discovery finds a device
            if (action.equals(mBluetoothAdapter.ACTION_STATE_CHANGED)) {
                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, mBluetoothAdapter.ERROR);

                switch(state){
                    case BluetoothAdapter.STATE_OFF:
                        Toast.makeText(getContext(),"State OFF", Toast.LENGTH_LONG).show();
                        break;
                    case BluetoothAdapter.STATE_TURNING_OFF:
                        Toast.makeText(getContext(),"State Turning OFF", Toast.LENGTH_LONG).show();
                        break;
                    case BluetoothAdapter.STATE_ON:
                        Toast.makeText(getContext(),"State ON", Toast.LENGTH_LONG).show();
                        break;
                    case BluetoothAdapter.STATE_TURNING_ON:
                        Toast.makeText(getContext(),"State Turning ON", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        }
    };

    private final BroadcastReceiver mBroadcastReceiver2 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();

            if (action.equals(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED)) {

                int mode = intent.getIntExtra(BluetoothAdapter.EXTRA_SCAN_MODE, BluetoothAdapter.ERROR);

                switch (mode) {
                    //Device is in Discoverable Mode
                    case BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE:
                        Toast.makeText(getContext(),"Discoverability Enabled", Toast.LENGTH_LONG).show();
                        break;
                    //Device not in discoverable mode
                    case BluetoothAdapter.SCAN_MODE_CONNECTABLE:
                        Toast.makeText(getContext(),"Discoverability Disabled. Able to receive connections", Toast.LENGTH_LONG).show();
                        break;
                    case BluetoothAdapter.SCAN_MODE_NONE:
                        Toast.makeText(getContext(),"Discoverability Disabled. Not able to receive connections", Toast.LENGTH_LONG).show();
                        break;
                    case BluetoothAdapter.STATE_CONNECTING:
                        Toast.makeText(getContext(),"Connecting....", Toast.LENGTH_LONG).show();
                        break;
                    case BluetoothAdapter.STATE_CONNECTED:
                        Toast.makeText(getContext(),"Connected", Toast.LENGTH_LONG).show();
                        break;
                }

            }
        }
    };

    private BroadcastReceiver mBroadcastReceiver3 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            Toast.makeText(getContext(),"ACTION FOUND", Toast.LENGTH_LONG).show();

            if (action.equals(BluetoothDevice.ACTION_FOUND)){
                BluetoothDevice device = intent.getParcelableExtra (BluetoothDevice.EXTRA_DEVICE);
                mBTDevices.add(device);
                Toast.makeText(getContext(),"ACTION FOUND" + device.getName() + ": " + device.getAddress(), Toast.LENGTH_LONG).show();
                mDeviceListAdapter = new DeviceListAdapter(context, R.layout.device_adapter_view, mBTDevices);
                listDevices.setAdapter(mDeviceListAdapter);
            }
        }
    };

    private final BroadcastReceiver mBroadcastReceiver4 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();

            if(action.equals(BluetoothDevice.ACTION_BOND_STATE_CHANGED)){
                BluetoothDevice mDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                //3 cases:
                //case1: bonded already
                if (mDevice.getBondState() == BluetoothDevice.BOND_BONDED){
                    Toast.makeText(getContext(),"BOND_BONDED", Toast.LENGTH_LONG).show();
                }
                //case2: creating a bone
                if (mDevice.getBondState() == BluetoothDevice.BOND_BONDING) {
                    Toast.makeText(getContext(),"BOND_BONDING", Toast.LENGTH_LONG).show();
                }
                //case3: breaking a bond
                if (mDevice.getBondState() == BluetoothDevice.BOND_NONE) {
                    Toast.makeText(getContext(),"BOND_NONE", Toast.LENGTH_LONG).show();
                }
            }
        }
    };




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scanbt_device,container,false);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        listDevices = view.findViewById(R.id.listDevices);
        btnEnableDisable_Discoverable = view.findViewById(R.id.btnDiscoverable_on_off);
        btnONOFF = view.findViewById(R.id.btnONOFF);
        btnDiscover = view.findViewById(R.id.btnFindUnpairedDevices);
        mBTDevices = new ArrayList<>();

        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        getActivity().registerReceiver(mBroadcastReceiver4, filter);

        listDevices.setOnItemClickListener(ScanDevice.this);


        implementListeners();

        return view;
    }

    private void implementListeners() {

        btnONOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"onClick: enabling/disabling bluetooth", Toast.LENGTH_LONG).show();
                enableDisableBT();
            }
        });

        btnEnableDisable_Discoverable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"btnEnableDisable_Discoverable: Making device discoverable for 300 seconds", Toast.LENGTH_LONG).show();

                Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
                startActivity(discoverableIntent);

                IntentFilter intentFilter = new IntentFilter(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED);
                getActivity().registerReceiver(mBroadcastReceiver2,intentFilter);
            }
        });

        btnDiscover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"btnDiscover: Looking for unpaired devices", Toast.LENGTH_LONG).show();

                if(mBluetoothAdapter.isDiscovering()){
                    mBluetoothAdapter.cancelDiscovery();
                    Toast.makeText(getContext(),"btnDiscover: Canceling discovery", Toast.LENGTH_LONG).show();

                    //check BT permissions in manifest
                    checkBTPermissions();

                    mBluetoothAdapter.startDiscovery();
                    IntentFilter discoverDevicesIntent = new IntentFilter(BluetoothDevice.ACTION_FOUND);
                    getActivity().registerReceiver(mBroadcastReceiver3, discoverDevicesIntent);
                }
                if(!mBluetoothAdapter.isDiscovering()){

                    //check BT permissions in manifest
                    checkBTPermissions();

                    mBluetoothAdapter.startDiscovery();
                    IntentFilter discoverDevicesIntent = new IntentFilter(BluetoothDevice.ACTION_FOUND);
                    getActivity().registerReceiver(mBroadcastReceiver3, discoverDevicesIntent);
                }
            }
        });


    }

    public void enableDisableBT(){
        if(mBluetoothAdapter == null){
            Toast.makeText(getContext(),"enableDisableBT: Does not have BT capabilities", Toast.LENGTH_LONG).show();
        }
        if(!mBluetoothAdapter.isEnabled()){
            Toast.makeText(getContext(),"enableDisableBT: enabling BT", Toast.LENGTH_LONG).show();
            Intent enableBTIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(enableBTIntent);

            IntentFilter BTIntent = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            getActivity().registerReceiver(mBroadcastReceiver1, BTIntent);
        }
        if(mBluetoothAdapter.isEnabled()){
            Toast.makeText(getContext(),"enableDisableBT: disabling BT", Toast.LENGTH_LONG).show();
            mBluetoothAdapter.disable();

            IntentFilter BTIntent = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            getActivity().registerReceiver(mBroadcastReceiver1, BTIntent);
        }

    }

    private void checkBTPermissions() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            int permissionCheck = ContextCompat.checkSelfPermission(getContext(),Manifest.permission.ACCESS_FINE_LOCATION);
            permissionCheck += ContextCompat.checkSelfPermission(getContext(),Manifest.permission.ACCESS_COARSE_LOCATION);
            if (permissionCheck != 0) {

                this.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1001); //Any number
            }
        } else {
            Toast.makeText(getContext(),"checkBTPermissions: No need to check permissions. SDK version < LOLLIPOP", Toast.LENGTH_LONG).show();
        }

    }

    @SuppressLint("ObsoleteSdkInt")
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

        mBluetoothAdapter.cancelDiscovery();

        Toast.makeText(getContext(),"onItemClick: You Clicked on a devicey", Toast.LENGTH_LONG).show();
        String deviceName = mBTDevices.get(i).getName();
        String deviceAddress = mBTDevices.get(i).getAddress();

        Toast.makeText(getContext(),"onItemClick: deviceName = " + deviceName, Toast.LENGTH_LONG).show();
        Toast.makeText(getContext(),"onItemClick: deviceAddress = " + deviceAddress, Toast.LENGTH_LONG).show();

        //create the bond.
        //NOTE: Requires API 17+? I think this is JellyBean
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
            Toast.makeText(getContext(),"Trying to pair with " + deviceName, Toast.LENGTH_LONG).show();
            mBTDevices.get(i).createBond();
        }

    }


}
