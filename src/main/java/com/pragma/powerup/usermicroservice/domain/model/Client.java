package com.pragma.powerup.usermicroservice.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Client {
    private Long id;
    private String numberDocument;
    private double ratingCinepacho;
    private int points;
}
