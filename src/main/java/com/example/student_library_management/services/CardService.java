package com.example.student_library_management.services;

import com.example.student_library_management.dtos.BookDto;
import com.example.student_library_management.dtos.ResponseCardFineDto;
import com.example.student_library_management.models.Book;
import com.example.student_library_management.models.LibraryCard;
import com.example.student_library_management.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;
    public ResponseCardFineDto checkCardFine(int cardId){
        LibraryCard libraryCard=cardRepository.findById(cardId).get();
        ResponseCardFineDto responseCardFineDto=new ResponseCardFineDto();
        responseCardFineDto.setTotalFine(libraryCard.getTotalFine());
        responseCardFineDto.setName(libraryCard.getStudentV().getName());
        responseCardFineDto.setUpdatedOn(libraryCard.getUpdatedOn());
        return responseCardFineDto;
    }
    public List<BookDto> getListOfBooksOnCard(int cardId){
        List<Book> bookList=cardRepository.findById(cardId).get().getAssignedBooks();
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
