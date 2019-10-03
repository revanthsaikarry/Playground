package com.example.addapprover;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carmel.Revanth.Model.PersonModel;
import com.example.addapprover.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddApproverPageFragment extends Fragment {

    private View rootView;
    RecyclerView peopleList;
    RecyclerView.Adapter recyclerAdapter;


    public AddApproverPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
            rootView = inflater.inflate(R.layout.fragment_add_approver_page, container, false);

            peopleList = rootView.findViewById(R.id.PeopleList);
            ArrayList people =new ArrayList();
            PersonModel personModel = new PersonModel();

            personModel.setPerson_name("Luke Ray");
            personModel.setPerson_details("Lorem ipsum doler sit amet.");
            people.add(personModel);

            personModel = new PersonModel();
            personModel.setPerson_name("Daisy Lake");
            personModel.setPerson_details("Lorem ipsum doler sit amet.");
            people.add(personModel);

            personModel = new PersonModel();
            personModel.setPerson_name("Mark Smith");
            personModel.setPerson_details("Lorem ipsum doler sit amet.");
            people.add(personModel);

            personModel = new PersonModel();
            personModel.setPerson_name("Daisy Lake");
            personModel.setPerson_details("Lorem ipsum doler sit amet.");
            people.add(personModel);

            personModel = new PersonModel();
            personModel.setPerson_name("Mark zuke");
            personModel.setPerson_details("Lorem ipsum doler sit amet.");
            people.add(personModel);

            recyclerAdapter = new RecylerAdapter(rootView.getContext(), people);
            peopleList.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
            peopleList.setItemAnimator(new DefaultItemAnimator());
            peopleList.setAdapter(recyclerAdapter);

            return rootView;
    }

}
