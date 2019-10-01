package com.example.login;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.login.Deligate.Request_Deligate;
import com.example.login.Model.RequestModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RequestViewFragment extends Fragment {

    View rootView;
    ListView listView;
    TextView Order_id, Order_Date, Order_Status;
    private RequestModel requestModel3;

    public RequestViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_request_view, container, false);

        listView = rootView.findViewById(R.id.listView1);
        ArrayList Items = new ArrayList();
        RequestModel requestModel = new RequestModel();

        requestModel.setItems_desc("IBM ThinkServer TS150 Tower Server With Max. Processor 1 x Intel Xeon E3 (Quad Core) E3-1225 v5\"(3.3 GHz /Cache 8 MB)... / STD MEMORY 8GB X 1/ MAX. MEMORY 64GB 4 Slots/HARD DRIVE 1 X 1TB SATA 3.5\" 7.2k SATA / STD. HDD BAY/ 3 bay MAX. HDD BAY upto 4 x 3.5\" +1 x 2.5\" bay/ OPTICAL Multi Burner/Integrated RAID 0,1,5,10 (RAID 121i).");
        requestModel.setItems_qty(01);
        requestModel.setItems_date("10 Jul 2019");
        requestModel.setItems_cost(45000);
        Items.add(requestModel);

        requestModel = new RequestModel();
        requestModel.setItems_desc("Lenovo ThinkServer TS450 (PN:70M2001VIH) With Max. Processor 1 x Intel Xeon E3 (Quad Core) E3-1225 v5”(3.3 GHz /Cache 8 MB)/ STD MEMORY 8GB X 1 MAX. MEMORY 64GB; 4 DIMM Memory Slots/ HARD DRIVE Open Bay/ 2.5” SAS/SATA HS Bays (8 bay MAX. HDD BAY upto 8 x 2.5” bay MAX. HDD BAY upto 16x2.5”)/OPTICAL Multi Burner/ PCIe RAID 0,1,10 (RAID 520i). Supports SAS & SATA drives/Power Supply Standard (Inbuilt) 1 x 450W Power Supply /Max: 2");
        requestModel.setItems_qty(01);
        requestModel.setItems_date("10 Jul 2019");
        requestModel.setItems_cost(45000);
        Items.add(requestModel);

        requestModel = new RequestModel();
        requestModel.setItems_desc("IBM X3300M4 Server With x3300M4/ Part NO:7382IA4/ Intel Xeon E5 1230v2 1.8 GHz,10 MB,1066MHz/ 1x 8GB RAM/ 1x500GB SATA HDD/ 3.5Simple-Swap/ MULTI BUTRNER");
        requestModel.setItems_qty(01);
        requestModel.setItems_date("10 Jul 2019");
        requestModel.setItems_cost(45000);
        Items.add(requestModel);


        requestModel = new RequestModel();
        requestModel.setItems_desc("IBM Lenovo ThinkServer RD450 Rack Server (PN:70Q90059IH) with 1 x Intel® Xeon® E5-2620v4 (2.1GHz/8C/20MB/85W/2133Mhz)/Max: 2 Processors/ STD MEMORY 16GB X 1 MAX. MEMORY 1 TB ;16 Slots/ HARD DRIVE : Open Bay (2.5” HOT Swap SAS/SATA STD. HDD BAY 8 bay / MAX. HDD BAY 16 bay with optical bay/24 bay without optical bay) / OPTICAL Multi Burner/ Integrated RAID 0,1,10 (RAID 110i). Supports only SATA drive/ Power Supply Standard (Inbuilt) 1 x 750W Power Supply Max: 2");
        requestModel.setItems_qty(01);
        requestModel.setItems_date("10 Jul 2019");
        requestModel.setItems_cost(45000);
        Items.add(requestModel);


        requestModel = new RequestModel();
        requestModel.setItems_desc("daptec 128 MB Raid Controller Pair. Pci-e SAS/SATA");
        requestModel.setItems_qty(01);
        requestModel.setItems_cost(45000);
        requestModel.setItems_date("10 Jul 2019");
        Items.add(requestModel);


        ListAdapter listAdapter = new MyListAdapterFragment(rootView.getContext(), Items);
        listView.setAdapter(listAdapter);


        Order_id = rootView.findViewById(R.id.request_no);
        Order_Date = rootView.findViewById(R.id.Status_date);
        Order_Status = rootView.findViewById(R.id.Status_txt);
        if (requestModel3 != null) {
            Order_id.setText(requestModel3.getReq_no());
            Order_Date.setText(requestModel3.getReq_date());
            Order_Status.setText(requestModel3.getRequestStatus().toString());
        }

        return rootView;
    }

    public void setDataStreching(RequestModel requestModel) {
        this.requestModel3 = requestModel;
    }
}
