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

class RecylerAdapter2 extends RecyclerView.Adapter {
    private Context context;
    ArrayList search_people;


    public RecylerAdapter2(Context context, ArrayList people) {
        this.context = context;
        this.search_people = people;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.personview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        PersonModel personModel = (PersonModel) this.search_people.get(position);
        myViewHolder.setUpData(personModel);
    }

    @Override
    public int getItemCount() {
        return search_people.size();
    }
    Integer count = new Integer(0);

    private class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView person_name, person_details;
        public ImageView profile_img, Addbutton_img, Remove_btn;
        ArrayList<Integer> selected_per = new ArrayList<>();

        public MyViewHolder(View itemView) {
            super(itemView);

            person_name = itemView.findViewById(R.id.ApproverName);
            person_details = itemView.findViewById(R.id.ApproverDetails);
            profile_img = itemView.findViewById(R.id.ApproverImg);
            Addbutton_img = itemView.findViewById(R.id.AddBtn);
            Addbutton_img.setTag(1);
            Remove_btn = itemView.findViewById(R.id.AddBtn);
            Addbutton_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Integer integer = (Integer) Addbutton_img.getTag();
                    switch (integer) {
                        case 1:
                            Addbutton_img.setImageResource(R.drawable.removebutton);
                            Addbutton_img.setTag(0);
                            count = count + 1;
                            selected_per.add((Integer) Addbutton_img.getTag());
                            break;
                        case 0:
                        default:
                            Addbutton_img.setImageResource(R.drawable.addbutton);
                            Addbutton_img.setTag(1);
                            count = count - 1;
                            selected_per.add((Integer) Addbutton_img.getTag());
                            break;
                    }
                }
            });
        }

        public void setUpData(PersonModel personModel) {
            person_name.setText(String.valueOf(personModel.getPerson_name()));
            person_details.setText(String.valueOf(personModel.getPerson_details()));
        }
    }
}
