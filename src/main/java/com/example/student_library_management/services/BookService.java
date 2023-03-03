package com.example.student_library_management.services;

import com.example.student_library_management.dtos.BookDto;
import com.example.student_library_management.enums.Genre;
import com.example.student_library_management.models.Author;
import com.example.student_library_management.models.Book;
import com.example.student_library_management.repository.AuthorRepository;
import com.example.student_library_management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    public String addBook(Book book){
        book.setGenre(Genre.ADVENTURE);
        int authorId=book.getAuthor().getId();

        Author author=authorRepository.findById(authorId).get();
        book.setAuthor(author);

        List<Book> books=author.getUnassignedBooks();
        books.add(book);
        author.setUnassignedBooks(books);

        authorRepository.save(author);

       return "book added successfully";
    }
    public BookDto getPopularBook(){
        List<Book> bookList=bookRepository.findAll();
        int max=0;
        Book book=null;
        for(Book b:bookList){
            if(b.getNumberOfTimesIssued()>max){
                max=b.getNumberOfTimesIssued();
                book=b;
            }
        }
        BookDto bookDto=new BookDto();
        bookDto.setName(book.getName());
        bookDto.setPages(book.getPages());
        bookDto.setRating(book.getRating());
//        bookDto.setNumberOfTimesIssued(book.getNumberOfTimesIssued());
        return bookDto;
    }
    public BookDto getPopularAvailableBookOfAuthor(int authorId){
        BookDto bookDto=new BookDto();
        int c=0;
        List<Book> bookList=authorRepository.findById(authorId).get().getUnassignedBooks();
        Book book=null;
        for(Book b:bookList){
            if(b.getNumberOfTimesIssued()>c&& !b.isIssueStatus()){
                c=b.getNumberOfTimesIssued();
                book=b;
            }
        }
        if(book==null) return bookDto;
        bookDto.setName(book.getName());
        bookDto.setRating(book.getRating());
        bookDto.setPages(book.getPages());
        return bookDto;
    }
    public BookDto getRecommendedBookOfCurrentBook(int bookId){
        Book currentBook=bookRepository.findById(bookId).get();
        List<Book> bookList=bookRepository.findAll();
        Book book=null;
        for(Book b:bookList){
            if(b.getGenre().equals(currentBook.getGenre())&&b.getAuthor().getId()==currentBook.getAuthor().getId()){
                if(!b.isIssueStatus()){
                    book=b;
                }
            }
        }
        if(book==null){
            for(Book b:bookList){
                if(b.getGenre().equals(currentBook.getGenre())){
                    if(!b.isIssueStatus()){
                        book=b;
                    }
                }
            }
        }
        if(book==null){
            for(Book b:bookList){
                if(b.getAuthor().getId()==currentBook.getAuthor().getId()){
                    if(!b.isIssueStatus()){
                        book=b;
                    }
                }
            }
        }
        if(book==null) return new BookDto();
        BookDto bookDto=new BookDto();
        bookDto.setPages(book.getPages());
        bookDto.setRating(book.getRating());
        bookDto.setName(book.getName());
        return bookDto;
    }
}
