package com.backend.cash.repository;

import com.backend.cash.model.Loan;
import com.backend.cash.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
     public Page<Loan> findByUser(Pageable page, User user);
 }
