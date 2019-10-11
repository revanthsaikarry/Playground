package com.example.addapprover;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.addapprover.Deligate.AddApproverDeloigate;
import com.example.addapprover.Model.PersonModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddApproverFragment extends Fragment  {

    private View rootView;
    RecyclerView peopleList;
    RecyclerView.Adapter recyclerAdapter;
    EditText search_text;
    ImageView searchView;
    Button doneBtn;
    AddApproverDeloigate addApproverDeloigate;
    String count;
    ArrayList selectedList;
    PersonModel personModel;
    PersonModel personModel1;
    public ImageView profile_img, Addbutton_img, Remove_btn;
    TextView selectionCount;
    ArrayList<PersonModel> selected_per = new ArrayList<PersonModel>();
    ArrayList<PersonModel> selectedArray = new ArrayList<>();
    TextView person_name, person_details;


    String Url = "https://myfirstewebsite.000webhostapp.com/people.json";


    public static final String PeopleListJson="{\"data\": " +
            "[{\"name\":\"Luke Ray\",\"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"}," +
            "{\"name\":\"Daisy Lake\",\"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"}," +
            "{\"name\":\"Mark SMith\",\"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"}," +
            "{\"name\":\"Richard Keys\",\"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"}," +
            "{\"name\":\"Amith Sharma\",\"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"}," +
            "{\"name\":\"Shruthi Iyer\",\"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"}, " +
            "{\"name\":\"Kumar Sravan\",\"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"}," +
            "{\"name\":\"Ananya Pandit\",\"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"}," +
            "{\"name\":\"Peter Dcruz\",\"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"}," +
            "{\"name\":\"Hussain Mallik\",\"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"}]}";

    public void setCount(String count){
        this.count = count;
    }

    public AddApproverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
            rootView = inflater.inflate(R.layout.fragment_add_approver_page, container, false);

            peopleList = rootView.findViewById(R.id.PeopleList);
//            ArrayList<String> name = new ArrayList();
//            ArrayList<String> desc = new ArrayList();
            person_name = rootView.findViewById(R.id.ApproverName);
            person_details = rootView.findViewById(R.id.ApproverDetails);
            selectionCount = rootView.findViewById(R.id.selectedCount);

        try {
            JSONObject peoplelistjson = new JSONObject(PeopleListJson);
            JSONArray jsonArray = peoplelistjson.getJSONArray("data");

            final ArrayList people =new ArrayList();
            for(int i=0;i< jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                PersonModel personModel = new PersonModel();

                String name1 = jsonObject.optString("name");
                String decs = jsonObject.optString("description");

//                name.add(name1);
//                desc.add(decs);

                personModel.setPerson_name(name1);
                personModel.setPerson_details(decs);
                people.add(personModel);

            }
            recyclerAdapter= new RecylerAdapter(rootView.getContext(), people);
            peopleList.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
            peopleList.setItemAnimator(new DefaultItemAnimator());
            peopleList.setAdapter(recyclerAdapter);
            recyclerAdapter.notifyDataSetChanged();


        } catch (JSONException e) {
            e.printStackTrace();
        }

//        StringRequest request=new StringRequest(Url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                responseJSONData(response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(rootView.getContext(), "There is an Error", Toast.LENGTH_LONG).show();
//            }
//        });
//        RequestQueue requestQueue = Volley.newRequestQueue(rootView.getContext());
//        requestQueue.add(request);

//
//        final ArrayList people =new ArrayList();
//            PersonModel personModel = new PersonModel();
//
//            personModel.setPerson_name("Luke Ray");
//            people.add(personModel);
//            personModel.setPerson_details("Lorem ipsum doler sit amet.");
//
//            personModel = new PersonModel();
//            personModel.setPerson_name("Daisy Lake");
//            personModel.setPerson_details("Lorem ipsum doler sit amet.");
//            people.add(personModel);
//
//            personModel = new PersonModel();
//            personModel.setPerson_name("Mark Smith");
//            personModel.setPerson_details("Lorem ipsum doler sit amet.");
//            people.add(personModel);
//
//            personModel = new PersonModel();
//            personModel.setPerson_name("Daisy Lake");
//            personModel.setPerson_details("Lorem ipsum doler sit amet.");
//            people.add(personModel);
//
//            personModel = new PersonModel();
//            personModel.setPerson_name("Mark zuke");
//            personModel.setPerson_details("Lorem ipsum doler sit amet.");
//            people.add(personModel);
//
//            recyclerAdapter = new RecylerAdapter(rootView.getContext(), people);
//            peopleList.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
//            peopleList.setItemAnimator(new DefaultItemAnimator());
//            peopleList.setAdapter(recyclerAdapter);


            search_text = rootView.findViewById(R.id.searchTxt);
            searchView =  rootView.findViewById(R.id.searchBtn);

            searchView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

//                    String searchTxt = search_text.getText().toString().trim().toUpperCase();
//                    String peopleTxt = personModel1.getPerson_name().trim().toUpperCase();
//                    if (searchTxt == peopleTxt){
//                        int i=people.indexOf(peopleTxt);
//                        peopleList.setVisibility(i);
//                    }else {
//                        peopleList.removeAllViews();
//                    }
//
                }
            });

//        Addbutton_img = rootView.findViewById(R.id.AddBtn);
        doneBtn = rootView.findViewById(R.id.doneBtn);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DONE", "onClick: BUTTON Clicked");
                if(addApproverDeloigate != null){
                    Log.d("If", "onClick: entered iff");
                    addApproverDeloigate.OnClickAddAppoverItem();
                }
            }
        });
//
//

//        if (personModel1 != null){
////            String name = String.valueOf(personModel1.getPerson_name());
////            String details = String.valueOf(personModel.getPerson_details());
//            selected_per.add(personModel1);
//        }

        selectionCount.setText(count);
        return rootView;

    }
//    public void setData(PersonModel personModel){
//        this.personModel1 = personModel;
//    }

}
