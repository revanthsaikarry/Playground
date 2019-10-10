package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class RecylerAdapterjson extends RecyclerView.Adapter<RecylerAdapterjson.MyViewHolder> {
    private Context context;
    JSONObject jsonList;

    public RecylerAdapterjson(Context context1, JSONObject jsonObject) {
        this.context = context1;
        this.jsonList = new JSONObject();
        this.jsonList = jsonObject;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.orderlist_content,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyViewHolder myViewHolder1= holder;
        try {
            JSONArray jsonArray = jsonList.getJSONArray("data");
            JSONObject jsonObject = jsonArray.getJSONObject(position);
            myViewHolder1.setUpData1(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int getItemCount() {
//        return 10;
        try {
            return jsonList.getJSONArray("data").length();
        } catch (JSONException e) {
            return Integer.parseInt(null);
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title,date,statusTxt;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            title=itemView.findViewById(R.id.orederId);
            date=itemView.findViewById(R.id.orderDate);
            statusTxt=itemView.findViewById(R.id.orderStatus);
            imageView=itemView.findViewById(R.id.imageView3);

        }

        public void setUpData1(JSONObject jsonList) {
            try {
                title.setText(jsonList.getString("title"));
                date.setText(jsonList.getString("date"));
                statusTxt.setText(jsonList.getString("status"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
