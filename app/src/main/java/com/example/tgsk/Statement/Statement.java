package com.example.tgsk.Statement;

public class Statement {

    private int id;
    private String namePatient;
    private String surnamePatient;
    private String type;
    private String dateEvent;
    private String clinicalDiagnosis;
    private String status;
    private String clinic;
    private String cart;
    private String optimalDate;
    private String hla_typing;

    public Statement(String namePatient, String surnamePatient, String type, String dateEvent, String clinicalDiagnosis, String status, String clinic, String cart, String optimalDate, String hla_typing) {
        this.namePatient = namePatient;
        this.surnamePatient = surnamePatient;
        this.type = type;
        this.dateEvent = dateEvent;
        this.clinicalDiagnosis = clinicalDiagnosis;
        this.status = status;
        this.clinic = clinic;
        this.cart = cart;
        this.optimalDate = optimalDate;
        this.hla_typing = hla_typing;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public String getSurnamePatient() {
        return surnamePatient;
    }

    public String getClinicalDiagnosis() {
        return clinicalDiagnosis;
    }

    public String getStatus() {
        return status;
    }

    public String getClinic() {
        return clinic;
    }

    public String getCart() {
        return cart;
    }

    public String getOptimalDate() {
        return optimalDate;
    }

    public String getHla_typing() {
        return hla_typing;
    }

    public String getName() {
        return namePatient;
    }

    public String getType() {
        return type;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public Statement(String name, String type, String dateEvent) {
        this.namePatient = name;
        this.type = type;
        this.dateEvent = dateEvent;
    }
}
