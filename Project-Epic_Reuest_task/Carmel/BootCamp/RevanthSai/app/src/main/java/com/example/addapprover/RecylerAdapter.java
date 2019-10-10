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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

class RecylerAdapter extends RecyclerView.Adapter {
    private Context context;
    ArrayList peoples_name, peoples_desc;
    ArrayList peoples_list;
    JSONObject jsonList;

    public RecylerAdapter(Context context, ArrayList name, ArrayList people) {
        this.context=context;
        this.peoples_name=name;
        this.peoples_desc=people;
    }

    public RecylerAdapter(Context context, ArrayList people) {
        this.context = context;
        this.peoples_list = people;
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
            MyViewHolder myViewHolder= (MyViewHolder) holder;
//            try{
//                JSONArray jsonArray = jsonList.getJSONArray("data");
//                JSONObject jsonObject = jsonArray.getJSONObject(position);
//                myViewHolder.setUpData(jsonObject);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }

//                RecylerAdapter.MyViewHolder myViewHolder = (RecylerAdapter.MyViewHolder)holder;
//                myViewHolder.setUpData(String.valueOf(peoples_name.get(position)),String.valueOf(peoples_desc.get(position)));
                PersonModel personModel = (PersonModel) this.peoples_list.get(position);
                myViewHolder.setUpData(personModel);
    }

    @Override
    public int getItemCount() {
//        try{
//            return jsonList.getJSONArray("").length();
//        } catch (JSONException e) {
//            return Integer.parseInt(null);
//        }
        return peoples_list.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView person_name, person_details;
        public ImageView profile_img, Addbutton_img, Remove_btn;

        public MyViewHolder(@NonNull View itemView) {
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
                    switch (integer){
                        case 1:
                            Addbutton_img.setImageResource(R.drawable.removebutton);
                            Addbutton_img.setTag(0);
                            break;
                        case 0:
                            default:
                            Addbutton_img.setImageResource(R.drawable.addbutton);
                            Addbutton_img.setTag(1);
                            break;
                    }
                }
            });
        }



//        public void setUpData(PersonModel people) {
//            try {
//                person_name.setText(jsonList.getString("name"));
//                person_details.setText(jsonList.getString("description"));
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            person_name.setText(String.valueOf(people.getPerson_name()));
//            person_details.setText(String.valueOf(people.getPerson_details()));
//        }


        public void setUpData(String valueOf, String valueOf1) {
            person_name.setText(valueOf);
            person_details.setText(valueOf1);
        }

        public void setUpData(PersonModel personModel) {
            person_name.setText(String.valueOf(personModel.getPerson_name()));
            person_details.setText(String.valueOf(personModel.getPerson_details()));
        }
    }
}
