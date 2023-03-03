package com.example.student_library_management.controllers;

import com.example.student_library_management.dtos.AuthorDto;
import com.example.student_library_management.dtos.IssueBookDto;
import com.example.student_library_management.dtos.ReturnBookDto;
import com.example.student_library_management.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("issue_book")
    public String issueBook(@RequestBody() IssueBookDto issueBookDto) throws Exception {
        try {
            return transactionService.issueBook(issueBookDto);
        }
        catch (Exception e){
            return e.getMessage();
        }

    }
    @PostMapping("return_book")
    public String returnBook(@RequestBody ReturnBookDto returnBookDto){
        try {
            return transactionService.returnBook(returnBookDto);
        }
        catch (Exception e){
            return e.getMessage();
        }

    }

}
