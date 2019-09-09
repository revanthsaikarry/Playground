package com.example.demoapp;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DemoClass extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        interfacedemo1(getApplicationContext());
    }



    DemoClass() {

    }


    public void interfacedemo1(Context applicationContext) {
        Log.d("Interace", "interfacedemo: This is the, mothod declaration of the method in the DemoClass");
        Toast toast = Toast.makeText(applicationContext,"After onclick This method is from DemoClass",Toast.LENGTH_LONG);
        toast.show();
    }

}
