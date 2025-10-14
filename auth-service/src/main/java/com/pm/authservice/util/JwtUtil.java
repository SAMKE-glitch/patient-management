package com.pm.authservice.util;

import java.security.Key;

public class JwtUtil {

    private final Key secretKey;

    public JwtUtil(Key secretKey) {
        this.secretKey = secretKey;
    }
}
