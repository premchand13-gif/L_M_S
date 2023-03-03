package com.example.student_library_management.models;
//package models;

import com.example.student_library_management.enums.CardStatus;
//import models.Student;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Library_card")
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;

    private int totalFine;
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;
    @OneToOne
    @JoinColumn
    private Student studentV;

    @OneToMany(mappedBy = "libraryCard",cascade = CascadeType.ALL)
    private List<Book> assignedBooks=new ArrayList<>();

    @OneToMany(mappedBy = "libraryCardT",cascade = CascadeType.ALL)
    private List<Transactions> transactionsList =new ArrayList<>();

    public LibraryCard() {
    }

    public int getTotalFine() {
        return totalFine;
    }

    public void setTotalFine(int totalFine) {
        this.totalFine = totalFine;
    }

    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }


    public List<Book> getAssignedBooks() {
        return assignedBooks;
    }

    public void setAssignedBooks(List<Book> assignedBooks) {
        this.assignedBooks = assignedBooks;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Student getStudentV() {
        return studentV;
    }

    public void setStudentV(Student studentV) {
        this.studentV = studentV;
    }


}
