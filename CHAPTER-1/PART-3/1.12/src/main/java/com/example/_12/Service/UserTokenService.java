package com.example._12.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserTokenService {

    private final String validToken;

    // Lấy giá trị của api.user-token gán vào validToken
    public UserTokenService(@Value("${api.user-token}") String validToken) {
        this.validToken = validToken; // Inject
    }

    public boolean isValid(String token) {
        return token != null && !token.isBlank() && validToken.equals(token.trim());
    }
}
