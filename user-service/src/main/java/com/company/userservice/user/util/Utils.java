package com.company.userservice.user.util;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class Utils {
    public String encodePassword(final String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt());
    }

    public boolean matchPassword(final String rawPassword, final String encodedPassword) {
        return BCrypt.checkpw(rawPassword, encodedPassword);
    }
}
