package com.company.userservice.user;

import com.company.userservice.user.dtos.UserCreateDto;
import com.company.userservice.user.dtos.UserDto;
import com.company.userservice.user.util.Utils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final Utils utils;

    public List<UserDto> getAll() {
        return repository.getAll();
    }

    public UserDto get(@NonNull long id) {
        return repository.get(id).orElseThrow(() -> {
            throw new RuntimeException("User not found!");
        });
    }

    public User create(UserCreateDto dto) {
        User user = User.builder()
                .username(dto.getUsername())
                .password(utils.encodePassword(dto.getPassword())).build();
        return repository.save(user);
    }

    public void delete(@NonNull long id) {
        repository.deleteById(id);
    }

    public boolean checkUserById(long id) {
        repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("User not found!");
        });
        return true;
    }
}
