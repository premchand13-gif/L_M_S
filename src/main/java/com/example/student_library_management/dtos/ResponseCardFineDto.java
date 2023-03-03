package com.example.student_library_management.dtos;

import java.util.Date;

public class ResponseCardFineDto {
    private String name;
    private int totalFine;
    private Date updatedOn;

    public ResponseCardFineDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalFine() {
        return totalFine;
    }

    public void setTotalFine(int totalFine) {
        this.totalFine = totalFine;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
}
