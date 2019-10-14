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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
    public ImageView profile_img, Addbutton_img, Remove_btn;
    TextView cancel;
    ArrayList<PersonModel> selected_per = new ArrayList<PersonModel>();
    ArrayList<PersonModel> selectedArray = new ArrayList<>();



    String Url = "https://myfirstewebsite.000webhostapp.com/people.json";

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



        RecylerListFragment recylerListFragment = new RecylerListFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentHolder2, recylerListFragment);
        fragmentTransaction.commit();

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
                    SearchOption searchOption = new SearchOption();
                    FragmentManager fragmentManager1 = getFragmentManager();
                    FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                    fragmentTransaction1.replace(R.id.fragmentHolder2, searchOption);
                    fragmentTransaction1.addToBackStack(null);
                    fragmentTransaction1.commit();
                    String searchTxt= search_text.getText().toString().trim().toUpperCase();

                        searchOption.searchPeople(searchTxt);
                }
            });

//        Addbutton_img = rootView.findViewById(R.id.AddBtn);
        doneBtn = rootView.findViewById(R.id.doneBtn);
        cancel = rootView.findViewById(R.id.save_draft_requisition5);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DONE", "onClick: BUTTON Clicked");
                RequisitionForm5 requisitionForm5= new RequisitionForm5();
                FragmentManager fragmentManager1 = getFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                fragmentTransaction1.add(R.id.fragmentHolder, requisitionForm5);
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
//                if(addApproverDeloigate != null){
//                    Log.d("If", "onClick: entered iff");
//                    addApproverDeloigate.OnClickAddAppoverItem();
//                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequisitionForm5 requisitionForm5= new RequisitionForm5();
                FragmentManager fragmentManager1 = getFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                fragmentTransaction1.add(R.id.fragmentHolder, requisitionForm5);
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });
//
//

//        if (personModel1 != null){
////            String name = String.valueOf(personModel1.getPerson_name());
////            String details = String.valueOf(personModel.getPerson_details());
//            selected_per.add(personModel1);
//        }

//        selectionCount.setText(count);
        return rootView;

    }
//    public void setData(PersonModel personModel){
//        this.personModel1 = personModel;
//    }

}
