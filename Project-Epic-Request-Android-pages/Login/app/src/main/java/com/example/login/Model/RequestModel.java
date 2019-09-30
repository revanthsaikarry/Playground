package com.example.login.Model;

import java.io.Serializable;


public class RequestModel implements Serializable {
    private String Req_no;
    private Enum requestStatus;
    private String Req_date;
    private String Items_desc;
    private Integer Items_qty;
    private String Items_date;
    private Integer Items_cost;


    public String getReq_no() {
        return Req_no;
    }

    public void setReq_no(String req_no) {
        Req_no = req_no;
    }

    public Enum getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(Enum requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getReq_date() {
        return Req_date;
    }

    public void setReq_date(String req_date) {
        Req_date = req_date;
    }

    public String getItems_desc() {
        return Items_desc;
    }

    public void setItems_desc(String items_desc) {
        Items_desc = items_desc;
    }

    public Integer getItems_qty() {
        return Items_qty;
    }

    public void setItems_qty(Integer items_qty) {
        Items_qty = items_qty;
    }

    public String getItems_date() {
        return Items_date;
    }

    public void setItems_date(String items_date) {
        Items_date = items_date;
    }

    public Integer getItems_cost() {
        return Items_cost;
    }

    public void setItems_cost(Integer items_cost) {
        Items_cost = items_cost;
    }
}
