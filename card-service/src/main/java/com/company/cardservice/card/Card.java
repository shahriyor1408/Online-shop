package com.company.cardservice.card;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cards")
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime expiry = LocalDateTime.now().plusYears(5);

    private long userId;
}
