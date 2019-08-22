package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter {
    String titles[], dates[], status[];
    private Context context;

    public MyListAdapter(Context context, String[] title, String[] date, String[] status){
        this.context=context;
        this.titles=title;
        this.dates=date;
        this.status=status;
    }
    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.orderlist_content,parent,false);
        TextView title,date,statusText;

        title=view.findViewById(R.id.orederId);
        date=view.findViewById(R.id.orderDate);
        statusText=view.findViewById(R.id.orderStatus);
        ImageView imageView=view.findViewById(R.id.imageView3);

        title.setText(String.valueOf(titles[position]));
        date.setText(String.valueOf(dates[position]));
        statusText.setText(String.valueOf(status[position]));

                return view;
    }
}
