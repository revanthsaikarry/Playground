package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button LoginBtn;
    ImageView image1;
    TextView txt1;
    ImageView image2;
    TextView txt2;
    TextView forgotTxt;
    EditText editText;
    TextView login_txt;


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
        editText = findViewById(R.id.editText2);
        login_txt = findViewById(R.id.loginBtn);

        login_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FragmentRequestPage.class);
                startActivity(intent);
            }
        });


        LoginBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
                    public void onClick(View v){
                if (editText.getText().toString().equals("")) {
                    image1.setVisibility(View.VISIBLE);
                    txt1.setVisibility(View.VISIBLE);
                    image2.setVisibility(View.VISIBLE);
                    txt2.setVisibility(View.VISIBLE);
                }
                      else{
                    Intent intent = new Intent(getApplicationContext(),BurgerMenu.class);
                    startActivity(intent);
                }
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
