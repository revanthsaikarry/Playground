package com.carmel.Revanth.Model;

import java.io.Serializable;

public class PersonModel implements Serializable {
    private String Person_name;
    private String Person_details;

    public String getPerson_name() {
        return Person_name;
    }

    public void setPerson_name(String person_name) {
        Person_name = person_name;
    }

    public String getPerson_details() {
        return Person_details;
    }

    public void setPerson_details(String person_details) {
        Person_details = person_details;
    }
}
