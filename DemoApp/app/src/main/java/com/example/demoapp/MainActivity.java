package com.example.demoapp;

    import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
    import android.view.View;
    import android.widget.Button;
    import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DemoTask,DemoInteface2 {

    Button Load_class_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        interfacedemo();
        DemoInterface();

        Load_class_btn = findViewById(R.id.Load_class_btn);
        Load_class_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DemoClass d = new DemoClass();
                d.interfacedemo1(getApplicationContext());
            }
        });
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



