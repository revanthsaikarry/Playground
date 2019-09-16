package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> item_id= new ArrayList<String>();
        ArrayList<String> item_name = new ArrayList<String>();
        ArrayList<String> item_order_date= new ArrayList<String>();

        item_id.add("PDA-122-007");
        item_name.add("Books");
        item_order_date.add("12-05-2019");

        MyAdapter myAdapter = new MyAdapter(getApplicationContext(), item_id, item_name, item_order_date);

     }
}
