package com.example.otelissue;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
class MyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    public UUID id() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
