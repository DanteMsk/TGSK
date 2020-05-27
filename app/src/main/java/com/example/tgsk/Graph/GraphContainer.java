package com.example.tgsk.Graph;

public class GraphContainer {
    private int newStatement;
    private int newStatementMis;
    private int newStatementMisCGM;
    private int deferredConsideration;
    private int hrHlaTyping;
    private int hlaTyping;
    private int applicationRejected;
    private int donorSearch;
    private int donorApproved;

    public int getNewStatement() {
        return newStatement;
    }

    public int getNewStatementMis() {
        return newStatementMis;
    }

    public int getNewStatementMisCGM() {
        return newStatementMisCGM;
    }

    public int getDeferredConsideration() {
        return deferredConsideration;
    }

    public int getHrHlaTyping() {
        return hrHlaTyping;
    }

    public int getHlaTyping() {
        return hlaTyping;
    }

    public int getApplicationRejected() {
        return applicationRejected;
    }

    public int getDonorSearch() {
        return donorSearch;
    }

    public int getDonorApproved() {
        return donorApproved;
    }

    public GraphContainer(int newStatement, int newStatementMis, int newStatementMisCGM, int deferredConsideration, int hrHlaTyping, int hlaTyping, int applicationRejected, int donorSearch, int donorApproved) {
        this.newStatement = newStatement;
        this.newStatementMis = newStatementMis;
        this.newStatementMisCGM = newStatementMisCGM;
        this.deferredConsideration = deferredConsideration;
        this.hrHlaTyping = hrHlaTyping;
        this.hlaTyping = hlaTyping;
        this.applicationRejected = applicationRejected;
        this.donorSearch = donorSearch;
        this.donorApproved = donorApproved;
    }

    private void requestProcessing(){
        // process the request here
    }
}
