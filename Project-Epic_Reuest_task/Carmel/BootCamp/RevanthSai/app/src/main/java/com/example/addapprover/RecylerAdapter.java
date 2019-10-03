package com.example.addapprover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carmel.Revanth.Model.PersonModel;
import com.example.addapprover.R;

import java.util.ArrayList;

class RecylerAdapter extends RecyclerView.Adapter {
    private Context context;
    ArrayList<PersonModel> peoples_list;

    public RecylerAdapter(Context context, ArrayList people) {
        this.context=context;
        this.peoples_list=people;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.personview, parent, false);
        MyViewHolder myViewHolader =new MyViewHolder(view1);

        return myViewHolader;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecylerAdapter.MyViewHolder myViewHolder = (RecylerAdapter.MyViewHolder)holder;
        PersonModel personModel = this.peoples_list.get(position);
        myViewHolder.setUpData(personModel);
    }

    @Override
    public int getItemCount() {
        return peoples_list.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView person_name, person_details;
        public ImageView profile_img, Addbutton_img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            person_name = itemView.findViewById(R.id.ApproverName);
            person_details = itemView.findViewById(R.id.ApproverDetails);
            profile_img = itemView.findViewById(R.id.ApproverImg);
            Addbutton_img = itemView.findViewById(R.id.AddBtn);
        }

        public void setUpData(PersonModel people) {
            person_name.setText(String.valueOf(people.getPerson_name()));
            person_details.setText(String.valueOf(people.getPerson_details()));
        }
    }
}
