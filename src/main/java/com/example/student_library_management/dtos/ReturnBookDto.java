package com.example.student_library_management.dtos;

public class ReturnBookDto {
    private int bookId;
    private int cardId;

    public ReturnBookDto(){

    }
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
}
