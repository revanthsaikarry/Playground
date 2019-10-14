package com.example.addapprover;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
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
public class SearchOption extends Fragment {
    private View rootView;
    ImageView searchNotfound;
    TextView searchNotFoundtxt1, searchNotFoundtxt2, searchNotFoundtxt3;
    RecyclerView searchResult;
    RecyclerView.Adapter recyclerAdapter2;
    ArrayList<PersonModel> people = new ArrayList<>();
    String searchTxt;

    public static final String PeopleListJson = "{\"data\": " +
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


    public SearchOption() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_search_option, container, false);

        searchResult = rootView.findViewById(R.id.searResultsHolder);

        searchNotfound = rootView.findViewById(R.id.searchnotfound);
        searchNotFoundtxt1 = rootView.findViewById(R.id.noresultsfound1);
        searchNotFoundtxt2 = rootView.findViewById(R.id.noresultsfound2);
        searchNotFoundtxt3 = rootView.findViewById(R.id.noresultsfound3);

        try {
            JSONObject jsonObject = new JSONObject(PeopleListJson);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            Log.d("name", "searchPeople: " + searchTxt);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                PersonModel personModel = new PersonModel();
                String name = String.valueOf(jsonObject1.optString("name").toUpperCase().trim());
                Log.d("name", "searchPeopleA: " + name);

                if (searchTxt.equals(name)) {
                    Log.d("matching", "searchPeopleAB: " + searchTxt + name);
                    String name1 = jsonObject1.optString("name");
                    String decs = jsonObject1.optString("description");
                    personModel = new PersonModel();
                    personModel.setPerson_name(name1);
                    personModel.setPerson_details(decs);
                    people.add(personModel);
                    searchNotfound.setVisibility(rootView.INVISIBLE);
                    searchNotFoundtxt1.setVisibility(rootView.INVISIBLE);
                    searchNotFoundtxt2.setVisibility(rootView.INVISIBLE);
                    searchNotFoundtxt3.setVisibility(rootView.INVISIBLE);
                    break;
                }else if (searchTxt.equals(null)){
                    Log.d("no results", "searchPeopleAA: "+searchTxt);
                    searchNotfound.setVisibility(rootView.VISIBLE);
                    searchNotFoundtxt1.setVisibility(rootView.VISIBLE);
                    searchNotFoundtxt2.setVisibility(rootView.VISIBLE);
                    searchNotFoundtxt3.setVisibility(rootView.VISIBLE);
                }else {
                    searchNotfound.setVisibility(rootView.VISIBLE);
                    searchNotFoundtxt1.setVisibility(rootView.VISIBLE);
                    searchNotFoundtxt2.setVisibility(rootView.VISIBLE);
                    searchNotFoundtxt3.setVisibility(rootView.VISIBLE);
                }
            }
            recyclerAdapter2 = new RecylerAdapter2(rootView.getContext(), people);
            searchResult.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
            searchResult.setItemAnimator(new DefaultItemAnimator());
            searchResult.setAdapter(recyclerAdapter2);

        } catch (JSONException e) {
            e.printStackTrace();
        }




        return rootView;
    }

    public void searchPeople(String searchTxt) {
        this.searchTxt = searchTxt;
    }
}
