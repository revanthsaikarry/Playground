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

class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.MyViewHolder> {
    String titles[], dates[], status[];
    private Context context;
    JSONObject jsonList;

    public RecylerAdapter(Context context, String[] title, String[] date, String[] statusTxt) {
        this.context = context;
        this.titles = title;
        this.dates = date;
        this.status = statusTxt;
    }

    @NonNull
    @Override
    public RecylerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.orderlist_content,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RecylerAdapter.MyViewHolder myViewHolder = (RecylerAdapter.MyViewHolder)holder;
        myViewHolder.setUpData(String.valueOf(titles[position]),String.valueOf((dates[position])),String.valueOf(status[position]));
        RecylerAdapter.MyViewHolder myViewHolder1 = (RecylerAdapter.MyViewHolder)holder;
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title,date,statusTxt;
        public ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.orederId);
            date=itemView.findViewById(R.id.orderDate);
            statusTxt=itemView.findViewById(R.id.orderStatus);
            imageView=itemView.findViewById(R.id.imageView3);
        }

        public void setUpData(String titles, String dates, String status) {
            title.setText(titles);
            date.setText(dates);
            statusTxt.setText(status);
            imageView.setImageResource(R.drawable.notification);
        }

        public void setUpData1(JSONObject jsonList) {
        }
    }
}
