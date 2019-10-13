package com.ridait.springsecurity.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PlainTextPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence password) {
        return password.toString();
    }

    @Override
    public boolean matches(CharSequence password, String otherPassword) {
        return password.toString().equals(otherPassword);
    }

}
