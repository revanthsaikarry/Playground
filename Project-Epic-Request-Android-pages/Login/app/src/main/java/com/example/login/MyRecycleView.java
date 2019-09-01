package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MyRecycleView extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter recycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recycle_view);

        recyclerView = findViewById(R.id.recycleView);
        String[] dates={"12-aug","15-aug","22-aug","18-aug","22-jul","12-jul","7-jul","8-jul"};
        String[] titles={"PUR-2019-056","PUR-2019-053","PUR-2019-065","PUR-2019-024","PUR-2019-015","PUR-2019-027","PUR-2019-018"};
        String[] status = {"CLEAR","APPROVED","AWAITED","DRAFT","REJECTED","DRAFT","REJECTED"};

        recycleViewAdapter = new RecylerAdapter(getApplicationContext(),titles,dates,status);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RecylerAdapter recylerAdapter = new RecylerAdapter(getApplicationContext(),titles,dates,status);
        recyclerView.setAdapter(recylerAdapter);

//        setContentView(R.layout.activity_my_recycle_view);
       //  BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

    }
}
