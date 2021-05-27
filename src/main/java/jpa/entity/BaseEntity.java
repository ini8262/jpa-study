package jpa.entity;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {
    private String createdId;
    private LocalDateTime createdDateTime;
}
