package com.backend.cash.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "loans")
@SQLDelete(sql = "UPDATE loans SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Loan extends EntityCommon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double total;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;




    private static final long serialVersionUID = 1L;
}
