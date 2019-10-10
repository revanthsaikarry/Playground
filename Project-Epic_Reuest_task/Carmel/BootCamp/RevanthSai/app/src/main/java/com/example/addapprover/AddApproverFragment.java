package com.example.addapprover;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatCallback;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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
    String Url = "https://myfirstewebsite.000webhostapp.com/people.json";

//    String peopleList1 = "{\n" +
//            "\t\"data\": [{\n" +
//            "\t\t\t\"name\": \"Luke Ray\",\n" +
//            "\t\t\t\"description\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"\n" +
//            "\t\t},\n" +
//            "\t\t{\n" +
//            "\t\t\t\"name\": \"Daisy Lake\",\n" +
//            "\t\t\t\"description\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"\n" +
//            "\t\t},\n" +
//            "\t\t{\n" +
//            "\t\t\t\"name\": \"Mark SMith\",\n" +
//            "\t\t\t\"description\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"\n" +
//            "\t\t},\n" +
//            "\t\t{\n" +
//            "\t\t\t\"name\": \"Richard Keys\",\n" +
//            "\t\t\t\"description\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"\n" +
//            "\t\t},\n" +
//            "\t\t{\n" +
//            "\t\t\t\"name\": \"Amith Sharma\",\n" +
//            "\t\t\t\"description\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"\n" +
//            "\t\t}, {\n" +
//            "\t\t\t\"name\": \"Shruthi Iyer\",\n" +
//            "\t\t\t\"description\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"\n" +
//            "\t\t}, {\n" +
//            "\t\t\t\"name\": \"Kumar Sravan\",\n" +
//            "\t\t\t\"description\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"\n" +
//            "\t\t}, {\n" +
//            "\t\t\t\"name\": \"Ananya Pandit\",\n" +
//            "\t\t\t\"description\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"\n" +
//            "\t\t}, {\n" +
//            "\t\t\t\"name\": \"Peter Dcruz\",\n" +
//            "\t\t\t\"description\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"\n" +
//            "\t\t}, {\n" +
//            "\t\t\t\"name\": \"Hussain Mallik\",\n" +
//            "\t\t\t\"description\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit\"\n" +
//            "\t\t}\n" +
//            "\t]\n" +
//            "}";
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

    public AddApproverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
            rootView = inflater.inflate(R.layout.fragment_add_approver_page, container, false);

            peopleList = rootView.findViewById(R.id.PeopleList);
            ArrayList<String> name = new ArrayList();
            ArrayList<String> desc = new ArrayList();

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
//            recyclerAdapter.notifyDataSetChanged();

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


        doneBtn = rootView.findViewById(R.id.doneBtn);
//        doneBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Integer integer = (Integer) Addbutton_img.getTag();
//                Integer i,j,k;
//                i = peoples_list.indexOf(Addbutton_img.getTag());
//                PersonModel personModel = (PersonModel) peoples_list.get(i);
//
//                RequisitionForm5 requisitionForm5fragment = new RequisitionForm5();
//
//                Bundle selectedPersonData = new Bundle();
//                selectedPersonData.putString("Person_name", personModel.getPerson_name());
//                selectedPersonData.putString("Person_Details", personModel.getPerson_details());
//
//                requisitionForm5fragment.setArguments(selectedPersonData);
//            }
//        });

        return rootView;

    }
//
//    private void responseJSONData(String response) {
//
//        try {
//            peopleList.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
//            peopleList.setItemAnimator(new DefaultItemAnimator());
//            JSONObject jsonObject = new JSONObject(response);
//            recyclerAdapter= new RecylerAdapter(rootView.getContext(), jsonObject);
//            peopleList.setAdapter(recyclerAdapter);
//            recyclerAdapter.notifyDataSetChanged();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }

}
