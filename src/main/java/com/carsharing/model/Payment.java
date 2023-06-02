package com.carsharing.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('PAID','PENDING')", nullable = false)
    private Status status;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "ENUM('FINE','PAYMENT')", nullable = false)
    private Type type;
    @MapsId
    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
    @Column(name = "session_url")
    private String sessionUrl;
    @Column(name = "session_id")
    private String sessionId;
    private BigDecimal amount;

    public enum Status {
        PENDING,
        PAID
    }

    public enum Type {
        PAYMENT,
        FINE
    }
}
