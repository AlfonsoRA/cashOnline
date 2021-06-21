package com.backend.cash.modelDTO;

import com.backend.cash.model.Loan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class UserDTO {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private List<LoanDTO> loans;

}
