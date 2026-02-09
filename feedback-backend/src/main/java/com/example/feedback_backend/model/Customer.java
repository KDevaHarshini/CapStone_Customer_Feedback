package com.example.feedback_backend.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column; // Added
import jakarta.persistence.PrePersist; // Added

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    
    private String email;
    private String firstName;
    

    @Column(updatable = false) 
    private LocalDateTime createdAt;


    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Customer() {}

    
    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getfirstName() { return firstName; }
    public void setfirstName(String firstName) { this.firstName = firstName; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}