package com.company.cardservice.card;

import com.company.cardservice.card.dtos.CardDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardDto toDto(Card card);

    List<CardDto> toDto(List<Card> cards);
}
