package com.example.login.Global;

public enum RequestStatus {
    APPROVED(0),
    AWAITING_APPROVAL(1),
    DRAFT(2),
    REJECTED(3);
    private int values;
    RequestStatus(int value) {
        this.values = value;
    }
}
