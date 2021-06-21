package com.backend.cash.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data @AllArgsConstructor @NoArgsConstructor
public class EntityCommon {

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    private Boolean deleted;

    @PrePersist
    private void prePersist() {
        this.createAt = new Date();
        this.deleted = false;
    }

    @PreUpdate
    private void preUpdate() {this.updateAt = new Date();}
}
