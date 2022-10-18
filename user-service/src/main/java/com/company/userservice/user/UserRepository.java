package com.company.userservice.user;

import com.company.userservice.user.dtos.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select new com.company.userservice.user.dtos.UserDto(t.id,t.username,t.createdAt) from User t")
    List<UserDto> getAll();

    @Query(value = "select new com.company.userservice.user.dtos.UserDto(t.id,t.username,t.createdAt) from User t where t.id = :id")
    Optional<UserDto> get(@Param(value = "id") long id);
}
