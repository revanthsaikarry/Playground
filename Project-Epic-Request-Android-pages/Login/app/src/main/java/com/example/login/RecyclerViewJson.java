package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RecyclerViewJson extends AppCompatActivity {

    Button loadBtn;
    String url="https://myfirstewebsite.000webhostapp.com/RequestJSONfile.json";
    RecyclerView recyclerView;
    RecyclerView.Adapter recyleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_json);



        recyclerView=findViewById(R.id.recyclerViewjson);
        loadBtn = findViewById(R.id.loadButton);
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request=new StringRequest(url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        responseJSONData(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"There is an error",Toast.LENGTH_LONG).show();
                    }
                });
                RequestQueue rQueue = Volley.newRequestQueue(RecyclerViewJson.this);
                rQueue.add(request);
            }
        });
    }

    public void responseJSONData(String response) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        try {
            JSONObject jsonObject = new JSONObject(response);
//            RecylerAdapterjson recyleViewAdapter = new RecylerAdapterjson(getApplicationContext(),jsonObject);
            recyleViewAdapter = new RecylerAdapterjson(getApplicationContext(),jsonObject);
            recyclerView.setAdapter(recyleViewAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}
