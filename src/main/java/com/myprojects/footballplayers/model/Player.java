package com.myprojects.footballplayers.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
 * LOMBOK Annotations used:
 * Default constructor
 * All args constructor
 * Getters
 * Setters
 * To String()
 * */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "player", uniqueConstraints = {
        @UniqueConstraint(name = "last_name_unique", columnNames = "last_name")
})

public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_generator")
    @SequenceGenerator(name = "player_generator", sequenceName = "player_sequence_name", allocationSize = 1)
    @Column(name = "player_id")
    private Long playerID;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "role")
    private String role;

    @Column(name = "value")
    private BigDecimal value;

    @CreationTimestamp
    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;
}
