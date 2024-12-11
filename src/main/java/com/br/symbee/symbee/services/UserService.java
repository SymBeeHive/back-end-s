package com.br.symbee.symbee.services;

import com.br.symbee.symbee.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void create(User user);

    String login(String email, String password) throws Exception;
}
