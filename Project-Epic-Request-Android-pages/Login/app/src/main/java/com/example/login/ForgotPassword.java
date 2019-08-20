package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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
    TextView txt1;

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
        txt1 = findViewById(R.id.textView11);
        final String txt = txt1.getText().toString();



        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(txt)) {
                    alertDialog.show();
            } else {
                    img1.setVisibility(1);
                    txt1.setVisibility(1);
             }
            }
        });
}
}
