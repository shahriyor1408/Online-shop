package com.company.cardservice.card.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardCreateDto {
    private String name;
    private String cardNumber;
    private long userId;
}
