package com.example.student_library_management.models;

import com.example.student_library_management.enums.Genre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int pages;
    private int numberOfTimesIssued;
    private Date issuedDate;
    private double rating;
    private boolean issueStatus=false;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    @ManyToOne
    @JoinColumn
    private Author author;

    @ManyToOne
    @JoinColumn
    private LibraryCard libraryCard;

//    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
//    private List<Transactions> transactionsListOfBook =new ArrayList<>();


    public Book() {
    }

    public int getNumberOfTimesIssued() {
        return numberOfTimesIssued;
    }

    public void setNumberOfTimesIssued(int numberOfTimesIssued) {
        this.numberOfTimesIssued = numberOfTimesIssued;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }
    //    public List<Transactions> getTransactionList() {
//        return transactionsListOfBook;
//    }

//    public void setTransactionList(List<Transactions> transactionsList) {
//        this.transactionsListOfBook = transactionsList;
//    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LibraryCard getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(LibraryCard libraryCard) {
        this.libraryCard = libraryCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(boolean issueStatus) {
        this.issueStatus = issueStatus;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
