package com.example.addapprover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.addapprover.Model.PersonModel;

import java.util.ArrayList;

class RecylerAdapter1 extends RecyclerView.Adapter {
    private Context context;
    ArrayList<PersonModel> ApprovarsSelected;
//    Button deleteBtn;


    public RecylerAdapter1(Context context, ArrayList<PersonModel> personModel) {
        this.context = context;
        this.ApprovarsSelected = personModel;
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
        PersonModel personModel = this.ApprovarsSelected.get(position);
        myViewHolder.setUpData(personModel);
    }

    @Override
    public int getItemCount() {
        return ApprovarsSelected.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView ApproverName, ApproverDetails;
        ImageView profilePic, deleteBtn;

        public MyViewHolder(View view) {
            super(view);

            ApproverName = view.findViewById(R.id.ApproverViewName);
            ApproverDetails = view.findViewById(R.id.ApproverViewDetails);
            deleteBtn = view.findViewById(R.id.deleteBtn);

            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    delete(getAdapterPosition());
                }
            });
        }

        private void delete(int adapterPosition) {
            ApproverName.endBatchEdit();
            notifyItemRemoved(adapterPosition);
        }

        public void setUpData(PersonModel personModel) {
            ApproverName.setText(String.valueOf(personModel.getPerson_name()));
            ApproverDetails.setText(String.valueOf(personModel.getPerson_details()));
        }
    }
}
