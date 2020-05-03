package com.example.harta;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.harta.RehabExercises.RehabArm;
import com.example.harta.RehabExercises.RehabBalance;
import com.example.harta.RehabExercises.RehabCore;
import com.example.harta.RehabExercises.RehabHand;
import com.example.harta.RehabExercises.RehabLeg;
import com.example.harta.RehabExercises.RehabSensoryReEd;
import com.example.harta.RehabExercises.RehabShoulder;

public class RehabFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_rehab, container, false);

        Button btnOpen= (Button) view.findViewById(R.id.sensoryBtn);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), RehabSensoryReEd.class);
                startActivity(in);
            }
        });

        Button btnOpen1= (Button) view.findViewById(R.id.armExercisesBtn);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), RehabArm.class);
                startActivity(in);
            }
        });

        Button btnOpen2= (Button) view.findViewById(R.id.balanceExercisesBtn);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), RehabBalance.class);
                startActivity(in);
            }
        });

        Button btnOpen3= (Button) view.findViewById(R.id.coreExercisesBtn);
        btnOpen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), RehabCore.class);
                startActivity(in);
            }
        });

        Button btnOpen4= (Button) view.findViewById(R.id.handExercisesBtn);
        btnOpen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), RehabHand.class);
                startActivity(in);
            }
        });

        Button btnOpen5= (Button) view.findViewById(R.id.legExercisesBtn);
        btnOpen5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), RehabLeg.class);
                startActivity(in);
            }
        });

        Button btnOpen6= (Button) view.findViewById(R.id.shoulderExercisesBtn);
        btnOpen6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), RehabShoulder.class);
                startActivity(in);
            }
        });
        return view;
    }

}
