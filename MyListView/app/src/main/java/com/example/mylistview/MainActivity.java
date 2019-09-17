package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> item_id= new ArrayList<String>();
        ArrayList<String> item_name = new ArrayList<String>();
        ArrayList<String> item_order_date= new ArrayList<String>();

        item_id.add("PDA-122-007");
        item_name.add("APPROVERD");
        item_order_date.add("12-05-2019");

        item_id.add("PDA-122-001");
        item_name.add("AWAITING");
        item_order_date.add("02-07-2019");


        item_id.add("PDA-122-005");
        item_name.add("REJECTED");
        item_order_date.add("15-04-2019");


        item_id.add("PDA-122-012");
        item_name.add("APPROVERD");
        item_order_date.add("10-06-2019");

        item_id.add("PDA-122-019");
        item_name.add("APPROVERD");
        item_order_date.add("18-06-2019");


        item_id.add("PDA-122-022");
        item_name.add("DRAFT");
        item_order_date.add("12-05-2019");

        item_id.add("PDA-122-032");
        item_name.add("DRAFT");
        item_order_date.add("15-07-2019");


        listView = findViewById(R.id.listView);
        MyAdapter myAdapter = new MyAdapter(getApplicationContext(), item_id, item_name, item_order_date);
        listView.setAdapter(myAdapter);


     }
}
