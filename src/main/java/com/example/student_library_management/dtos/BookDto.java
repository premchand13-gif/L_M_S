package com.example.student_library_management.dtos;

public class BookDto {
    private String name;
    private int pages;
//    private int numberOfTimesIssued;

    private double rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

//    public int getNumberOfTimesIssued() {
//        return numberOfTimesIssued;
//    }
//
//    public void setNumberOfTimesIssued(int numberOfTimesIssued) {
//        this.numberOfTimesIssued = numberOfTimesIssued;
//    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
