package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button LoginBtn;
    ImageView image1;
    TextView txt1;
    ImageView image2;
    TextView txt2;
    TextView forgotTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        image1 = findViewById(R.id.imageView5);
        image2 = findViewById(R.id.imageView);
        LoginBtn = findViewById(R.id.LoginBtn);
        txt1 = findViewById(R.id.textView8);
        txt2 = findViewById(R.id.textView6);
        forgotTxt = findViewById(R.id.textView5);

        LoginBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
                    public void onClick(View v){
                      image1.setVisibility(1);
                      txt1.setVisibility(1);
                      image2.setVisibility(1);
                      txt2.setVisibility(1);
                    }

                });
        forgotTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ForgotPassword.class);
                startActivity(intent);

            }
        });
    }
}
