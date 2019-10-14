package com.example.addapprover;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.addapprover.Model.PersonModel;

import org.json.JSONObject;

import java.util.ArrayList;

class RecylerAdapter extends RecyclerView.Adapter {
    private Context context;
    ArrayList peoples_name, peoples_desc;
    ArrayList peoples_list;
    JSONObject jsonList;
    ArrayList selectedList;
    PersonModel personModel;
    EditText searchPeople;
    ImageView searchBtn;

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
                PersonModel personModel = (PersonModel) this.peoples_list.get(position);
                myViewHolder.setUpData(personModel);
    }

    @Override
    public int getItemCount() {
        return peoples_list.size();
    }
    Integer count = new Integer(0);

    private class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView person_name, person_details;
        ArrayList<Integer> selected_per = new ArrayList<>();
        ArrayList<PersonModel> selectedArray = new ArrayList<>();
        Button done_btn;
        public ImageView profile_img, Addbutton_img, Remove_btn;
        TextView selectionCount;
        RequisitionForm5 requisitionForm5 = new RequisitionForm5();
        AddApproverFragment addApproverFragment = new AddApproverFragment();
        String str;



        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            person_name = itemView.findViewById(R.id.ApproverName);
            person_details = itemView.findViewById(R.id.ApproverDetails);
            profile_img = itemView.findViewById(R.id.ApproverImg);
            Addbutton_img = itemView.findViewById(R.id.AddBtn);
            done_btn = itemView.findViewById(R.id.doneBtn);
            searchPeople = itemView.findViewById(R.id.searchTxt);
            searchBtn = itemView.findViewById(R.id.searchBtn);
            selectionCount = (TextView) itemView.findViewById(R.id.selectedCount);
            final String selected_person;


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
                            count = count+1;
                            selected_per.add((Integer) Addbutton_img.getTag());
                            break;
                        case 0:
                        default:
                            Addbutton_img.setImageResource(R.drawable.addbutton);
                            Addbutton_img.setTag(1);
                            count = count-1;
                            selected_per.add((Integer) Addbutton_img.getTag());
                            break;
                    }


//                    for(int i=0;i<selected_per.size();i++){
//                        if(selected_per.get(i)==0){
//                            count = count+1;
//                        }else if (selected_per.get(i)==1){
//                            count = count-1;
//                        }
//                    }

                    if(count != 0){
                        Log.d("selected", +count+"onClick: +count+");
                        str = count+" selected";
                    }else if (count < 0){
                        Log.d("none selected", "onClick: NONE");
                        str = "None Selected";
                    }
                    PersonModel personModel;
                    for (int i = 0; i < selected_per.size(); i++) {
                        if (selected_per.get(i) == 0) {
                            personModel = new PersonModel();
                            personModel.setPerson_name(String.valueOf(person_name.getText()));
                            personModel.setPerson_details(String.valueOf(person_details.getText()));
                            requisitionForm5.setApproverData(personModel);
                        } else if (selected_per.get(i) == 1) {
                            count = count - 1;
                        }
                    }
                }

            });
            addApproverFragment.setCount(str);
        }


        public void setUpData(final PersonModel personModel) {
                        person_name.setText(String.valueOf(personModel.getPerson_name()));
                        person_details.setText(String.valueOf(personModel.getPerson_details()));
                    }
    }

    public void selected_person(PersonModel personModel) {
            this.personModel = personModel;
            selectedList.add(String.valueOf(personModel));
        for (int j = 0; j < selectedList.size(); j++) {
            Log.d("Array", "onClick: " + selectedList.get(j));
        }
    }

}
