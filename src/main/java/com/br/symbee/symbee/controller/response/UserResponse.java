package com.br.symbee.symbee.controller.response;

import com.br.symbee.symbee.domain.User;
import lombok.Data;

import java.util.Date;

@Data
public class UserResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String cpf;
    private Date birthDate;

    public static UserResponse convertTo(User user) {
        UserResponse userResponse = new UserResponse();

        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setCpf(user.getCpf());
        userResponse.setBirthDate(user.getDataNascimento());

        return userResponse;
    }
}
