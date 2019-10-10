package com.example.addapprover;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.addapprover.Deligate.AddApproverDeloigate;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RequisitionForm5 extends Fragment {
    ImageView AddApproverBtn;
    private View rootView;
    AddApproverDeloigate addApproverDeligate;
    RecyclerView selectedApprovarsList;
    RecyclerView.Adapter recyclerAdapter;

    public RequisitionForm5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_requisition_form5, container, false);

        AddApproverBtn = rootView.findViewById(R.id.addApproverBtn);

        AddApproverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(addApproverDeligate != null){
                    addApproverDeligate.OnClickAddAppoverBtn();
                }
            }
        });
        ArrayList<String> selectedAppovarsName = new ArrayList<String>();
        ArrayList<String> selectedAppovarsDetails = new ArrayList<String>();
        String personName, personDetails;


        Bundle bundle = this.getArguments();
        if (bundle != null){
            personName = bundle.getString("Person_name");
            selectedAppovarsName.add(personName);
            personDetails = bundle.getString("Person_Details");
            selectedAppovarsDetails.add(personDetails);
            recyclerAdapter = new RecylerAdapter1(rootView.getContext(), selectedAppovarsName, selectedAppovarsDetails);
            selectedApprovarsList.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
            selectedApprovarsList.setItemAnimator(new DefaultItemAnimator());
            selectedApprovarsList.setAdapter(recyclerAdapter);
        }


        return rootView;
    }
    public void setAddApprovarDeligate(AddApproverDeloigate addApprovarDeligate1){
        this.addApproverDeligate = addApprovarDeligate1;
    }
}
