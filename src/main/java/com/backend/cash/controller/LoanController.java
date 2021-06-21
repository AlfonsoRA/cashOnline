package com.backend.cash.controller;

import com.backend.cash.model.Loan;
import com.backend.cash.model.User;
import com.backend.cash.modelDTO.LoanDTO;
import com.backend.cash.modelDTO.UserDTO;
import com.backend.cash.service.interfaces.ILoanService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class LoanController {

    @Autowired
    private ILoanService loanService;

    @PostMapping("loans")
    public ResponseEntity<?> save(@Valid @RequestBody Loan loan){
        LoanDTO loanDTO = loanService.loanSave(loan);
        return new ResponseEntity(loanDTO, HttpStatus.CREATED);
    }

    @GetMapping("loans")
    public String loanPage(@RequestParam("page") Integer page,
                           @RequestParam("size") Integer size) throws NotFoundException {
        return loanService.loanPage(page, size);
    }

    @GetMapping("loansId")
    public String loanPageId(@RequestParam("page") Integer page,
                             @RequestParam("size") Integer size,
                             @RequestParam("id") Long id) throws NotFoundException {
        return loanService.loanPageId(page, size, id);
    }

}
