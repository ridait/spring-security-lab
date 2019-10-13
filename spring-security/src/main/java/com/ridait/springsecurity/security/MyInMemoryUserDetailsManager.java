package com.ridait.springsecurity.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.ArrayList;
import java.util.List;

public class MyInMemoryUserDetailsManager implements UserDetailsManager {


    List<UserDetails> users = new ArrayList<>();

    @Override
    public void createUser(UserDetails userDetails) {
        users.add(userDetails);
    }

    @Override
    public void updateUser(UserDetails userDetails) {
        //to be implemented

    }

    @Override
    public void deleteUser(String s) {
        //to be implemented
    }

    @Override
    public void changePassword(String s, String s1) {
        //to be implemented

    }

    @Override
    public boolean userExists(String username) {
        return  this.users.stream()
                .filter(userDetails -> userDetails.getUsername().equals(username))
                .findFirst()
                .isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.users.stream()
                .filter(userDetails -> userDetails.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("Username Not Found"));
    }
}
