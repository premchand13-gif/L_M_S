package com.example.student_library_management.services;

import com.example.student_library_management.dtos.AuthorDto;
import com.example.student_library_management.dtos.IssueBookDto;
import com.example.student_library_management.dtos.ReturnBookDto;
import com.example.student_library_management.enums.CardStatus;
import com.example.student_library_management.enums.TransactionStatus;
import com.example.student_library_management.models.Author;
import com.example.student_library_management.models.Book;
import com.example.student_library_management.models.LibraryCard;
import com.example.student_library_management.models.Transactions;
import com.example.student_library_management.repository.AuthorRepository;
import com.example.student_library_management.repository.BookRepository;
import com.example.student_library_management.repository.CardRepository;
import com.example.student_library_management.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    AuthorRepository authorRepository;
    public String issueBook(IssueBookDto issueBookDto) throws Exception{
        int bookId=issueBookDto.getBookId();
        int cardId=issueBookDto.getCardId();
        Book book=bookRepository.findById(bookId).get();
        LibraryCard libraryCard=cardRepository.findById(cardId).get();
        Transactions transactions =new Transactions();
        transactions.setBookIssued(true);
        transactions.setTransactionStatus(TransactionStatus.PENDING);
        if(book==null||book.isIssueStatus()){
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            throw new Exception("Book not found");
        }
        if(libraryCard==null||libraryCard.getCardStatus()!= CardStatus.ACTIVATED){
            transactions.setTransactionStatus(TransactionStatus.FAILED);

            throw new Exception("card not found");
        }
        transactions.setTransactionStatus(TransactionStatus.PASSED);
//        transactions.setBook(book);
        transactions.setLibraryCard(libraryCard);
        book.setLibraryCard(libraryCard);
        Date x=new Date();
        book.setIssuedDate(x);
        book.setIssueStatus(true);
        book.setNumberOfTimesIssued(book.getNumberOfTimesIssued()+1);
        Author author=book.getAuthor();
        author.setPopularityCount(author.getPopularityCount()+1);
        List<Book> bookList=libraryCard.getAssignedBooks();
        bookList.add(book);
        libraryCard.setAssignedBooks(bookList);

//
        List<Transactions> transactionsList1 =libraryCard.getTransactionsList();
        transactionsList1.add(transactions);
        libraryCard.setTransactionsList(transactionsList1);
        authorRepository.save(author);
        cardRepository.save(libraryCard);
        return "Transaction successful";
    }
    public String returnBook(ReturnBookDto returnBookDto) throws Exception{
        int cardId=returnBookDto.getCardId();
        int bookId=returnBookDto.getBookId();
        LibraryCard libraryCard=cardRepository.findById(cardId).get();
        Book book=bookRepository.findById(bookId).get();
        Transactions transactions=new Transactions();
        transactions.setBookIssued(false);
        transactions.setTransactionStatus(TransactionStatus.PENDING);
        if(book==null||!book.isIssueStatus()){
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            throw new Exception("Book not assigned");
        }
        if(libraryCard==null||libraryCard.getCardStatus()!= CardStatus.ACTIVATED){
            transactions.setTransactionStatus(TransactionStatus.FAILED);

            throw new Exception("card not found");
        }
        transactions.setTransactionStatus(TransactionStatus.PASSED);
//        transactions.setBook(book);
        transactions.setLibraryCard(libraryCard);
        book.setIssueStatus(false);
        long bookFine = ((book.getIssuedDate().getTime() - new Date().getTime()) / (1000 * 60 * 24))%365;
        if(bookFine>15){
            int f=(int)bookFine-15;
            transactions.setFine(f);
            libraryCard.setTotalFine(libraryCard.getTotalFine()+f);
        }

        libraryCard.getAssignedBooks().remove(book);
//        book.setLibraryCard(null);

//

        List<Transactions> transactionsList1 =libraryCard.getTransactionsList();
        transactionsList1.add(transactions);
        libraryCard.setTransactionsList(transactionsList1);

        cardRepository.save(libraryCard);
        bookRepository.save(book);

        return "returned successfully";
    }

}
