package com.ridait.springsecurity.security;

import com.ridait.springsecurity.entities.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import static java.util.Arrays.asList;

public class User implements UserDetails {

    private UserEntity userEntity;

    public User(UserEntity userEntity){
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return asList(()-> userEntity.getAuthority());
    }

    @Override
    public String getPassword() {
        return this.userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
