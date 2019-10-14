package com.example.addapprover;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.addapprover.Model.PersonModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecylerListFragment extends Fragment {

    private View rootView;
    RecyclerView peopleList;
    RecyclerView.Adapter recyclerAdapter;
    TextView person_name, person_details;
    ArrayList people =new ArrayList();


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

    public RecylerListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_recyler_list, container, false);

        peopleList = rootView.findViewById(R.id.PeopleList);
//            ArrayList<String> name = new ArrayList();
//            ArrayList<String> desc = new ArrayList();
        person_name = rootView.findViewById(R.id.ApproverName);
        person_details = rootView.findViewById(R.id.ApproverDetails);
//        selectionCount = rootView.findViewById(R.id.selectedCount);
        try {
            JSONObject peoplelistjson = new JSONObject(PeopleListJson);
            JSONArray jsonArray = peoplelistjson.getJSONArray("data");


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


        } catch (JSONException e) {
            e.printStackTrace();
        }
        recyclerAdapter= new RecylerAdapter(rootView.getContext(), people);
        peopleList.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        peopleList.setItemAnimator(new DefaultItemAnimator());
        peopleList.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();

        return rootView;
    }

}
