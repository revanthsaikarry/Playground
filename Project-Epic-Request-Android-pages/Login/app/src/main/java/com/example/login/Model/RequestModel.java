package com.example.login.Model;

import java.io.Serializable;


public class RequestModel implements Serializable {
    private String Req_no;
    private Enum requestStatus;
    private String Req_date;


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
}
