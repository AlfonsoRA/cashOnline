package com.backend.cash.service.interfaces;

import com.backend.cash.model.Loan;
import com.backend.cash.modelDTO.LoanDTO;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;

public interface ILoanService {

    public LoanDTO loanSave(Loan loan);
    public String loanPage(Integer pageLoan, Integer sizeLoan) throws NotFoundException;
    public String loanPageId(Integer pageLoan, Integer sizeLoan, Long id) throws NotFoundException;
}
