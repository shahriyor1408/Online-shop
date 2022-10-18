package com.company.userservice.user;

import lombok.*;

import javax.persistence.*;
import java.time.Clock;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now(Clock.systemDefaultZone());
}
