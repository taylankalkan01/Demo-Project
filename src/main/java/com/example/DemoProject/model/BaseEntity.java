package com.example.DemoProject.model;


import javax.persistence.Entity;
import java.time.LocalDateTime;


public class BaseEntity {
    private final LocalDateTime createdDate = null;
    private final LocalDateTime updatedDate = null;

    public BaseEntity() {
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }
}

