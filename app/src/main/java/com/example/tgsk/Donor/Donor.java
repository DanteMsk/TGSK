package com.example.tgsk.Donor;

public class Donor {

    private String name;
    private String surName;
    private String MidName;
    private String dateBirth;
    private String relationship;
    private String gender;
    private int age;
    private double weight;
    private double height;
    private int idDonorMIS;

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getMidName() {
        return MidName;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public String getRelationship() {
        return relationship;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getIdDonorMIS() {
        return idDonorMIS;
    }

    public Donor(String name, String surName, String midName,
                 String dateBirth, String relationship, String gender,
                 int age, double weight, double height, int idDonorMIS) {
        this.name = name;
        this.surName = surName;
        MidName = midName;
        this.dateBirth = dateBirth;
        this.relationship = relationship;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.idDonorMIS = idDonorMIS;
    }

    public Donor(){
    }

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

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setIdDonorMIS(int idDonorMIS) {
        this.idDonorMIS = idDonorMIS;
    }
}
