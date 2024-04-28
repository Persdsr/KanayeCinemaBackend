package com.example.kanaye.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "roles")
@Setter
@Getter
@NoArgsConstructor
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role(ERole name) {
        this.name = name;
    }

    public Role(Long id, ERole name) {
        this.id = id;
        this.name = name;
    }
}
