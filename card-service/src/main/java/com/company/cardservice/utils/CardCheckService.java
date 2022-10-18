package com.company.cardservice.utils;

import com.company.cardservice.card.dtos.CardCreateDto;
import com.company.cardservice.clients.UserClient;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardCheckService {
    private final UserClient userClient;

    public void checkOnCreate(@NonNull CardCreateDto dto) {
        if (!userClient.checkUserExists(dto.getUserId())) {
            throw new RuntimeException("User not found");
        }
    }
}
