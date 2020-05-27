package com.example.tgsk.Status;
public class StatusAndEvent {

    private String status;
    private String dateStatus;

    public String getStatus() {
        return status;
    }

    public String getDateStatus() {
        return dateStatus;
    }

    public StatusAndEvent(String status, String dateStatus) {
        this.status = status;
        this.dateStatus = dateStatus;
    }

    public StatusAndEvent() {

    }
}
