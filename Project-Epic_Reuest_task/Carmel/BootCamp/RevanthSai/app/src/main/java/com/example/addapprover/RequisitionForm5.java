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
import android.widget.ImageView;

import com.example.addapprover.Deligate.AddApproverDeloigate;
import com.example.addapprover.Model.PersonModel;

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
    PersonModel personModel;

    public RequisitionForm5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_requisition_form5, container, false);

        selectedApprovarsList = rootView.findViewById(R.id.appoverList);
        AddApproverBtn = rootView.findViewById(R.id.addApproverBtn);

        AddApproverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(addApproverDeligate != null){
                    addApproverDeligate.OnClickAddAppoverBtn();
                }
                AddApproverFragment addApproverFragment = new AddApproverFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentHolder, addApproverFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        ArrayList<PersonModel> selectedAppovars = new ArrayList<>();
        personModel = new PersonModel();
        personModel.setPerson_name("Luke rey");
        personModel.setPerson_details("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        selectedAppovars.add(personModel);

        personModel = new PersonModel();
        personModel.setPerson_name("Daisy Lake");
        personModel.setPerson_details("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        selectedAppovars.add(personModel);

        personModel = new PersonModel();
        personModel.setPerson_name("Mark Smith");
        personModel.setPerson_details("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        selectedAppovars.add(personModel);

        recyclerAdapter = new RecylerAdapter1(rootView.getContext(), selectedAppovars);
        selectedApprovarsList.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        selectedApprovarsList.setAdapter(recyclerAdapter);



        return rootView;
    }
    public void setAddApprovarDeligate(AddApproverDeloigate addApprovarDeligate1){
        this.addApproverDeligate = addApprovarDeligate1;
    }
    public void setApproverData(PersonModel personModel){
        this.personModel = personModel;
    }
}
