package com.example.addapprover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.addapprover.Model.PersonModel;

import java.util.ArrayList;

class RecylerAdapter1 extends RecyclerView.Adapter {
    private Context context;
    ArrayList<String> ApprovarsName;
    ArrayList<String> ApprovarsDetails;


    public RecylerAdapter1(Context context, ArrayList<String> selectedAppovarsName, ArrayList<String> selectedAppovarsDetails) {
        this.context = context;
        this.ApprovarsName = selectedAppovarsName;
        this.ApprovarsDetails = selectedAppovarsDetails;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.approvarview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecylerAdapter1.MyViewHolder myViewHolder = (RecylerAdapter1.MyViewHolder)holder;
        myViewHolder.setUpData(String.valueOf(ApprovarsName.get(position)),String.valueOf(ApprovarsDetails.get(position)));
    }

    @Override
    public int getItemCount() {
        return ApprovarsName.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView ApproverName, ApproverDetails;
        ImageView profilePic, deleteBtn;

        public MyViewHolder(View view) {
            super(view);

            ApproverName = view.findViewById(R.id.ApproverViewName);
            ApproverDetails = view.findViewById(R.id.ApproverViewDetails);
        }

        public void setUpData(String ApproversName, String ApproversDetails) {
            ApproverName.setText(ApproversName);
            ApproverDetails.setText(ApproversDetails);
        }
    }
}
