package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    String Url="https://myfirstewebsite.000webhostapp.com/sample.json";
    String request_list= "{ \"request_data\" :[{\"title\":\"PUR-122-007\", \"status\":\"APPROVED\", \"date\":\"10-jul\"}]}";

    String strJson="{ \"request\" :" +
            "[{\"title\":\"PUR-122-007\",\"status\":\"APPROVED\",\"date\":\"10-jul\"}," +
            "{\"title\":\"PUR-122-008\",\"status\":\"APPROVED\",\"date\":\"10-jul\"}] }";

    String strJson1 ="{ \"request\" :" +
            "[{\"title\":\"PUR-2019-056\",\"date\":\"12-AUG\",\"status\":\"CLEAR\"}," +
            "{\"title\":\"PUR-2019-057\",\"date\":\"15-AUG\",\"status\":\"APPROVED\"}," +
            "{\"title\":\"PUR-2019-058\",\"date\":\"22-AUG\",\"status\":\"AWAITED\"}," +
            "{\"title\":\"PUR-2019-059\",\"date\":\"18-AUG\",\"status\":\"DRAFT\"}," +
            "{\"title\":\"PUR-2019-060\",\"date\":\"02-SEP\",\"status\":\"APPROVED\"}," +
            "{\"title\":\"PUR-2019-062\",\"date\":\"10-SEP\",\"status\":\"REJECTED\"}," +
            "{\"title\":\"PUR-2019-063\",\"date\":\"12-SEP\",\"status\":\"DRAFT\"}," +
            "{\"title\":\"PUR-2019-065\",\"date\":\"12-SEP\",\"status\":\"APPROVED\"}," +
            "{\"title\":\"PUR-2019-066\",\"date\":\"14-SEP\",\"status\":\"CLEAR\"}," +
            "{\"title\":\"PUR-2019-056\",\"date\":\"16-SEP\",\"status\":\"AWAITED\"}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> item_id= new ArrayList<String>();
        ArrayList<String> item_name = new ArrayList<String>();
        ArrayList<String> item_order_date= new ArrayList<String>();
        textView = findViewById(R.id.textView);

        String data = "";
        try{
            JSONObject requestObject = new JSONObject(request_list);
            JSONObject jsonObject = new JSONObject(strJson1);
            JSONArray jsonArray = jsonObject.getJSONArray("request");

            JSONArray requestList = requestObject.optJSONArray("request_data");

            for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                String id = jsonObject1.optString("title");
                String salary = jsonObject1.optString("date");
                String name = jsonObject1.optString("status");

                item_id.add(id);
                item_name.add(name);
                item_order_date.add(salary);

                data += "Node"+i+" : \n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n ";
            }
//                textView.setText(data);
//            for (int i=0;i<=requestList.length();i++){
//                JSONObject jsonObject1 = requestList.getJSONObject(i);
////                String title = requestObject.optString("title").toString();
////                item_id.add(title);
//
////                item_id.add(jsonObject1.optString("title"));
////                item_name.add(jsonObject1.optString("status"));
////                item_order_date.add(jsonObject1.optString("date"));
////                String title1 = requestObject.optString("title");
////                textView.setText(String.valueOf(title1));
//            }
            listView = findViewById(R.id.listView);
            MyAdapter myAdapter = new MyAdapter(getApplicationContext(), item_id, item_name, item_order_date);
            listView.setAdapter(myAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

//        item_id.add("PDA-122-007");
//        item_name.add("APPROVERD");
//        item_order_date.add("12-05-2019");
//
//        item_id.add("PDA-122-001");
//        item_name.add("AWAITING");
//        item_order_date.add("02-07-2019");
//
//
//        item_id.add("PDA-122-005");
//        item_name.add("REJECTED");
//        item_order_date.add("15-04-2019");
//
//
//        item_id.add("PDA-122-012");
//        item_name.add("APPROVERD");
//        item_order_date.add("10-06-2019");
//
//        item_id.add("PDA-122-019");
//        item_name.add("APPROVERD");
//        item_order_date.add("18-06-2019");
//
//
//        item_id.add("PDA-122-022");
//        item_name.add("DRAFT");
//        item_order_date.add("12-05-2019");
//
//        item_id.add("PDA-122-032");
//        item_name.add("DRAFT");
//        item_order_date.add("15-07-2019");




     }
}
