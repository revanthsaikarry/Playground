package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ForgotPassword extends AppCompatActivity {
    Button submit_btn;
    AlertDialog.Builder alertBuilder;
    EditText editText;
    ImageView img1;
    ImageView img2;
    TextView txt1;
    TextView txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        alertBuilder = new AlertDialog.Builder(this);
        final View alertView = getLayoutInflater().inflate(R.layout.activity_alert_msg, null);
        alertBuilder.setView(alertView);
        final AlertDialog alertDialog = alertBuilder.create();

        editText = findViewById(R.id.editText);
        submit_btn = findViewById(R.id.button);
        img1 = findViewById(R.id.imageView6);
        img2 = findViewById(R.id.imageView4);

        txt1 = findViewById(R.id.textView11);
        txt2 = findViewById(R.id.textView7);



        submit_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().equals("")) {
                    img1.setVisibility(View.VISIBLE);
                    txt1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    txt2.setVisibility(View.VISIBLE);
                }

                else if (editText.getText().toString().equals("rev")){
                    Intent intent = new Intent(getApplicationContext(),BurgerMenu.class);
                    startActivity(intent);
                }

                else{
                    alertDialog.show();
                }
            }
        });
}
}
