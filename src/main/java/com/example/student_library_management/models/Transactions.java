package com.example.student_library_management.models;

import com.example.student_library_management.enums.TransactionStatus;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String transactionId= UUID.randomUUID().toString();
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;
    private int fine;
    private boolean isBookIssued;
//

    @ManyToOne
    @JoinColumn
    private LibraryCard libraryCardT;

    public Transactions() {
    }

    public boolean isBookIssued() {
        return isBookIssued;
    }

    public void setBookIssued(boolean bookIssued) {
        isBookIssued = bookIssued;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }

    public LibraryCard getLibraryCard() {
        return libraryCardT;
    }

    public void setLibraryCard(LibraryCard libraryCard) {
        this.libraryCardT = libraryCard;
    }
}
