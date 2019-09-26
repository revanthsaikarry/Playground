package com.example.login;

import android.content.Intent;
import android.os.Bundle;

import com.example.login.Global.RequestStatus;
import com.example.login.Model.RequestModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BurgerMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button request_btn;
    ImageView filter;
    TextView popup;
    ListPopupWindow listPopupWindow;
    List list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

            listView=findViewById(R.id.listView);
          filter=findViewById(R.id.filterOption);
        String[] content_list = {"CLEAR","APPROVED","AWAITED","DRAFT","REJECTED"};

        final ArrayList requestList = new ArrayList();

        RequestModel requestModel = new RequestModel();
        requestModel.setReq_no("PUR-2019-056");
        requestModel.setRequestStatus(RequestStatus.APPROVED);
        requestModel.setReq_date("12-aug");
        requestList.add(requestModel);

        requestModel = new RequestModel();
        requestModel.setReq_no("PUR-2019-053");
        requestModel.setRequestStatus(RequestStatus.AWAITING_APPROVAL);
        requestModel.setReq_date("15-aug");
        requestList.add(requestModel);

        requestModel = new RequestModel();
        requestModel.setReq_no("PUR-2019-065");
        requestModel.setRequestStatus(RequestStatus.REJECTED);
        requestModel.setReq_date("22-aug");
        requestList.add(requestModel);

        requestModel = new RequestModel();
        requestModel.setReq_no("PUR-2019-024");
        requestModel.setRequestStatus(RequestStatus.DRAFT);
        requestModel.setReq_date("18-aug");
        requestList.add(requestModel);

        requestModel = new RequestModel();
        requestModel.setReq_no("PUR-2019-015");
        requestModel.setRequestStatus(RequestStatus.AWAITING_APPROVAL);
        requestModel.setReq_date("18-aug");
        requestList.add(requestModel);

        requestModel = new RequestModel();
        requestModel.setReq_no("PUR-2019-035");
        requestModel.setRequestStatus(RequestStatus.APPROVED);
        requestModel.setReq_date("24-aug");
        requestList.add(requestModel);


        ListAdapter listAdapter=new MyListAdapter(getApplicationContext(),requestList);
        listView.setAdapter(listAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {



                RequestModel request = (RequestModel) requestList.get(i);

                Intent intent = new Intent(getApplicationContext(), RequisitionForm2.class);
                Bundle requestDataBundle = new Bundle();
                requestDataBundle.putString("RequestNumber", request.getReq_no());
                requestDataBundle.putString("RequestDate", request.getReq_date());
                requestDataBundle.putString("RequestStatus", request.getRequestStatus().toString());

                intent.putExtra("request", requestDataBundle);
                startActivity(intent);

            }

        });

//        popup = findViewById(R.id.openPopup);
        listPopupWindow = new ListPopupWindow(getApplicationContext());
        listPopupWindow.setAdapter(new ArrayAdapter(getApplicationContext(),R.layout.contentlist,content_list));
        listPopupWindow.setAnchorView(filter);
        listPopupWindow.setModal(true);
//        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.contentlist,content_list);
//        dataAdapter.setDropDownViewResource(android.R.layout.list_content);

//        listView.setAdapter(new ArrayAdapter<>(getApplicationContext(),R.layout.contentlist,content_list));


        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listPopupWindow.show();
//                dataAdapter.show();
            }
        });

        request_btn = findViewById(R.id.button2);

        request_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RequisitionActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.burger_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

//        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}