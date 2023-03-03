package com.example.student_library_management.controllers;

import com.example.student_library_management.dtos.BookDto;
import com.example.student_library_management.models.Book;
import com.example.student_library_management.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("add_book")
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("popular_book")
    public BookDto getPopularBook(){

        return bookService.getPopularBook();
    }
    @GetMapping("/popular_book_of_author")
    public BookDto getPopularAvailableBookOfAuthor(@RequestParam int authorId){
        return bookService.getPopularAvailableBookOfAuthor(authorId);
    }
    @GetMapping("/get_recommended_book")
    public BookDto getRecommendedBookOfCurrentBook(@RequestParam int bookId){
        return bookService.getRecommendedBookOfCurrentBook(bookId);
    }
}
