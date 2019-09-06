package com.example.demoapp;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class DemoClass {
    private Context activity;
    //Context context = getActivity().getApplicationContext();
    //private Context activity;

    DemoClass() {

    }

    public void interfacedemo1() {
        Log.d("Interace", "interfacedemo: This is the, mothod declaration of the method in the DemoClass");
        //Toast toast =  Toast.makeText(getActivity().getApplicationContext(),"This method is from Class DenoClass",Toast.LENGTH_LONG);
    }

}
