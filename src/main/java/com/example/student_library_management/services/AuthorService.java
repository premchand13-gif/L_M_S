package com.example.student_library_management.services;

import com.example.student_library_management.dtos.AuthorDto;
import com.example.student_library_management.dtos.BookDto;
import com.example.student_library_management.models.Author;
import com.example.student_library_management.models.Book;
import com.example.student_library_management.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public String createAuthor(Author author){
        authorRepository.save(author);
        return "Author created successfully";
    }
    public AuthorDto getPopularAuthor(){
        List<Author> authorList=authorRepository.findAll();
        int max=0;
        Author author=null;
        for(Author a:authorList){
            List<Book> bookList=a.getUnassignedBooks();
            int c=0;
            for(Book b:bookList){
                c=c+b.getNumberOfTimesIssued();
            }
            if(c>max){
                max=c;
                author=a;
            }
        }
        AuthorDto authorDto=new AuthorDto();

        authorDto.setAge(author.getAge());
        authorDto.setName(author.getName());
        authorDto.setCountry(author.getCountry());
//        authorDto.setPoints(author.getPopularityCount());
        return authorDto;
    }
    public List<BookDto> getListOfBooksPublishedByAuthor(int cardId){
        List<Book> bookList=authorRepository.findById(cardId).get().getUnassignedBooks();
        List<BookDto> bookDtos=new ArrayList<>();
        for(Book b:bookList){
            BookDto bookDto=new BookDto();
            bookDto.setPages(b.getPages());
            bookDto.setRating(b.getRating());
            bookDto.setName(b.getName());
            bookDtos.add(bookDto);
        }
        return bookDtos;

    }
}
