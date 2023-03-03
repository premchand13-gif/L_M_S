package com.example.student_library_management.controllers;

import com.example.student_library_management.dtos.BookDto;
import com.example.student_library_management.dtos.ResponseCardFineDto;
import com.example.student_library_management.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;

    @GetMapping("/check_fine")
    public ResponseCardFineDto checkFineOnCard(@RequestParam int cardId){
        return cardService.checkCardFine(cardId);
    }
    @GetMapping("/get_list_of_books_on_card")
    public List<BookDto> getListOfBooksOnCard(@RequestParam int cardId){
        return cardService.getListOfBooksOnCard(cardId);
    }
}
