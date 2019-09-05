package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d( "onCreate", "onCreate: onCreate is Started");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d( "onStartTag", "onStart: onStar is Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d( "onResumeTag", "onResume: onResume is Started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d( "onPauseTag", "onPause: onPause is Started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d( "onStopTag", "onStop: onStop is Started");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d( "onDestroy", "onDestroy: onDestroy is Started");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d( "onRestart", "onRestart: onRestrat is Started");
    }
}
