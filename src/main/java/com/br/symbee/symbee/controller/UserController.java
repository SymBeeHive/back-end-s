package com.br.symbee.symbee.controller;

import com.br.symbee.symbee.controller.response.UserResponse;
import com.br.symbee.symbee.domain.User;
import com.br.symbee.symbee.services.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserResponse> getAll(){
        List<User> users = userService.getAll();
        return users.stream().map(UserResponse::convertTo).toList();
    }

    @PostMapping
    public void create(@RequestBody UserRequest userRequest){
        userService.create(userRequest.toUser());
    }

    @Data
    public static class UserRequest {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String cpf;
        private Date birthDate;

        public User toUser(){
            User user = new User();

            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(password);
            user.setCpf(cpf);
            user.setDataNascimento(birthDate);

            return user;
        }
    }
}