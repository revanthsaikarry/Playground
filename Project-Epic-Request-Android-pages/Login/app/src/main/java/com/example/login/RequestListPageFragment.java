package com.example.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.TextView;

import com.example.login.Deligate.Request_Deligate;
import com.example.login.Global.RequestStatus;
import com.example.login.Model.RequestModel;

import java.util.ArrayList;


public class RequestListPageFragment extends Fragment{
    Button New_req_btn;
    ImageView filter_img;
    ListView listView;
    ListPopupWindow listPopupWindow;
    TextView filter_txt;
    private View rootView;
  private   Request_Deligate request_deligate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_request_list_page, container, false);

        listView = rootView.findViewById(R.id.listView1);


        final String[] content_list = {"CLEAR","APPROVED","AWAITED","DRAFT","REJECTED"};


        final ArrayList requestList = new ArrayList();
        RequestModel requestModel = new RequestModel();
        requestModel.setReq_no("PUR-2019-056");
        requestModel.setRequestStatus(RequestStatus.APPROVED);
        requestModel.setReq_date("12-aug");
        requestList.add(requestModel);

        requestModel = new RequestModel();
        requestModel.setReq_no("PUR-2019-053");
        requestModel.setRequestStatus(RequestStatus.AWAITING_APPROVAL);
        requestModel.setReq_date("15-aug");
        requestList.add(requestModel);

        requestModel = new RequestModel();
        requestModel.setReq_no("PUR-2019-065");
        requestModel.setRequestStatus(RequestStatus.REJECTED);
        requestModel.setReq_date("22-aug");
        requestList.add(requestModel);

        requestModel = new RequestModel();
        requestModel.setReq_no("PUR-2019-024");
        requestModel.setRequestStatus(RequestStatus.DRAFT);
        requestModel.setReq_date("18-aug");
        requestList.add(requestModel);

        requestModel = new RequestModel();
        requestModel.setReq_no("PUR-2019-015");
        requestModel.setRequestStatus(RequestStatus.AWAITING_APPROVAL);
        requestModel.setReq_date("18-aug");
        requestList.add(requestModel);

        requestModel = new RequestModel();
        requestModel.setReq_no("PUR-2019-035");
        requestModel.setRequestStatus(RequestStatus.APPROVED);
        requestModel.setReq_date("24-aug");
        requestList.add(requestModel);


        final ListAdapter listAdapter = new MyListAdapter(rootView.getContext(), requestList);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {


                RequestModel request = (RequestModel) requestList.get(i);

                if(request_deligate != null){
                    request_deligate.OnClickRequestItem(request);
                }
//                Intent intent = new Intent(rootView.getContext(), RequisitionForm2.class);
//                Bundle requestDataBundle = new Bundle();
//                requestDataBundle.putString("RequestNumber", request.getReq_no());
//                requestDataBundle.putString("RequestDate", request.getReq_date());
//                requestDataBundle.putString("RequestStatus", request.getRequestStatus().toString());
            }

        });
//                intent.putExtra("request", requestDataBundle);
//                startActivity(intent);

                filter_img = rootView.findViewById(R.id.filterOptionFragment);

                filter_txt = rootView.findViewById(R.id.openPopup);

                listPopupWindow = new ListPopupWindow(rootView.getContext());
                listPopupWindow.setAdapter(new ArrayAdapter(rootView.getContext(),R.layout.contentlist,content_list));
                listPopupWindow.setAnchorView(filter_img);
                listPopupWindow.setModal(true);

                filter_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            listPopupWindow.show();
                    }
                });





    return rootView;
    }

    public void setRequestDelegate(Request_Deligate requestDelegate){
        this.request_deligate = requestDelegate;
    }
}