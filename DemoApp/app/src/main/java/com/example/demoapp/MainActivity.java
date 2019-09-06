package com.example.demoapp;

    import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DemoTask,DemoInteface2 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       DemoClass d = new DemoClass();
       d.interfacedemo1();
        interfacedemo();
        DemoInterface();
    }

    @Override
    public void interfacedemo() {
        Log.d("Interface", "interfacedemo: This method is from Inteface DemoTask.....");
        Toast toast=Toast.makeText(getApplicationContext(), "This method is from inteface", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void DemoInterface() {
        Toast toast=Toast.makeText(getApplicationContext(), "this method is from DemoInterface2", Toast.LENGTH_LONG);
        toast.show();
    }
}



