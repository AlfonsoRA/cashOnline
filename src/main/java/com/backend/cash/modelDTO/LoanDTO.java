package com.backend.cash.modelDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class LoanDTO{

    private Long id;
    private Double total;
    private Long userId;
}
