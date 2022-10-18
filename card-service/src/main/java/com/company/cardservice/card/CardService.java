package com.company.cardservice.card;

import com.company.cardservice.card.dtos.CardCreateDto;
import com.company.cardservice.card.dtos.CardDto;
import com.company.cardservice.clients.UserClient;
import com.company.cardservice.utils.CardCheckService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final CardRepository repository;
    private final CardCheckService cardCheckService;
    private final CardMapper cardMapper;
    private final UserClient userClient;

    public CardService(CardRepository repository, CardCheckService cardCheckService, CardMapper cardMapper, UserClient userClient) {
        this.repository = repository;
        this.cardCheckService = cardCheckService;
        this.cardMapper = cardMapper;
        this.userClient = userClient;
    }

    public Card create(@NonNull CardCreateDto dto) {
        cardCheckService.checkOnCreate(dto);
        Card card = Card.builder()
                .name(dto.getName())
                .cardNumber(dto.getCardNumber())
                .userId(dto.getUserId())
                .build();
        return repository.save(card);
    }

    public CardDto get(@NonNull long id) {
        Card card = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Card not found!");
        });
        CardDto cardDto = cardMapper.toDto(card);
        cardDto.setUsername(userClient.getUserNameByUserID(card.getUserId()));
        return cardDto;
    }

    public List<CardDto> getAll() {
        List<Card> cards = repository.findAll();
        List<CardDto> dtos = cardMapper.toDto(cards);
        for (int i = 0; i < dtos.size(); i++) {
            dtos.get(i).setUsername(userClient.getUserNameByUserID(cards.get(i).getUserId()));
        }
        return dtos;
    }

    public void delete(@NonNull long id) {
        repository.deleteById(id);
    }
}
