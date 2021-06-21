package com.backend.cash.service.impl;

import com.backend.cash.component.PaginationComponent;
import com.backend.cash.model.Loan;
import com.backend.cash.model.User;
import com.backend.cash.modelDTO.LoanDTO;
import com.backend.cash.modelDTO.UserDTO;
import com.backend.cash.repository.LoanRepository;
import com.backend.cash.repository.UserRepository;
import com.backend.cash.service.interfaces.ILoanService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoanServiceImpl implements ILoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PaginationComponent paginationComponent;

    @Override
    @Transactional
    public LoanDTO loanSave(Loan loan) {
        LoanDTO loanDTO = modelToDTO(loanRepository.save(loan));
        return loanDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public String loanPage(Integer pageLoan, Integer sizeLoan) throws NotFoundException {
        Pageable pag = PageRequest.of(pageLoan, sizeLoan);
        Page<Loan> loans = loanRepository.findAll(pag);
        if (loans.getTotalPages() <= pag.getPageNumber())
            throw new NotFoundException("No existe la pagina: "+ pageLoan);
        return paginationComponent.changePaginationResponse(loans.map(this::modelToDTO), sizeLoan);
    }

    @Override
    @Transactional(readOnly = true)
    public String loanPageId(Integer pageLoan, Integer sizeLoan, Long id) throws NotFoundException {
        Pageable pag = PageRequest.of(pageLoan, sizeLoan);
        User user = userRepository.findById(id).orElse(null);
        Page<Loan> loans = loanRepository.findByUser(pag, user);
        if (loans.getTotalPages() <= pag.getPageNumber())
            throw new NotFoundException("No existe la pagina: "+ pageLoan);
        return paginationComponent.changePaginationResponse(loans.map(this::modelToDTO), sizeLoan);
    }

    private LoanDTO modelToDTO(Loan loan){
        return modelMapper.map(loan, LoanDTO.class);
    }

    private Loan dtoToModel(LoanDTO loanDTO){
        return modelMapper.map(loanDTO, Loan.class);
    }

}
