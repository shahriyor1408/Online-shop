package com.company.cardservice.card.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    private long id;
    private String name;
    private String cardNumber;
    private LocalDateTime expiry;
    private String username;

    public CardDto(long id, String name, String cardNumber, LocalDateTime expiry) {
        this.id = id;
        this.name = name;
        this.cardNumber = cardNumber;
        this.expiry = expiry;
    }
}
