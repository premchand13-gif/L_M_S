package com.example.student_library_management.controllers;

import com.example.student_library_management.dtos.AuthorDto;
import com.example.student_library_management.dtos.BookDto;
import com.example.student_library_management.models.Author;
import com.example.student_library_management.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("add_author")
    public String createAuthor(@RequestBody Author author){
        return authorService.createAuthor(author);
    }
    @GetMapping("popular_author")
    public AuthorDto getPopularAuthor(){
        return authorService.getPopularAuthor();
    }
    @GetMapping("/get_list_of_books_published_author")
    public List<BookDto> getListOfBooksPublishedByAuthor(@RequestParam int authorId){
        return authorService.getListOfBooksPublishedByAuthor(authorId);
    }
}
