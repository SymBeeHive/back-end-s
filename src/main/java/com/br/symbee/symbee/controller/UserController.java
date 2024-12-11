package com.br.symbee.symbee.controller;

import com.br.symbee.symbee.controller.response.UserResponse;
import com.br.symbee.symbee.domain.User;
import com.br.symbee.symbee.services.UserService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/register")
    public void create(@RequestBody UserRequest userRequest){
        userService.create(userRequest.toUser());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLogin userLogin) throws Exception {
        return ResponseEntity.ok(userService.login(userLogin.getEmail(), userLogin.getPassword()));
    }

    @Data
    public static class UserRequest {
        @JsonProperty("first_name")
        private String firstName;
        @JsonProperty("last_name")
        private String lastName;
        private String email;
        private String password;
        private String cpf;
        @JsonProperty("data_nascimento")
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

    @Data
    public static class UserLogin{
        private String email;
        private String password;
    }
}