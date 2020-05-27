package com.example.tgsk.Patient;

public class Patient {
    private String name;
    private String surName;
    private String MidName;
    private String dateBirth;
    private String gender;
    private int age;
    private int idDonorMIS;
    private int idDonorLIS;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setMidName(String midName) {
        MidName = midName;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIdDonorMIS(int idDonorMIS) {
        this.idDonorMIS = idDonorMIS;
    }

    public void setIdDonorLIS(int idDonorLIS) {
        this.idDonorLIS = idDonorLIS;
    }

    public Patient(String name, String surName, String midName, String dateBirth, String gender, int age, int idDonorMIS, int idDonorLIS) {
        this.name = name;
        this.surName = surName;
        MidName = midName;
        this.dateBirth = dateBirth;
        this.gender = gender;
        this.age = age;
        this.idDonorMIS = idDonorMIS;
        this.idDonorLIS = idDonorLIS;
    }

    public Patient(){}
}
