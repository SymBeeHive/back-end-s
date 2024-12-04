package com.br.symbee.symbee.domain;

import com.br.symbee.symbee.entities.UserEntity;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String cpf;
    private String password;
    private Date dataNascimento;

    public static User convertToUser(UserEntity userEntity) {
        User user = new User();
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setEmail(userEntity.getEmail());
        user.setCpf(userEntity.getCpf());
        user.setPassword(userEntity.getPassword());
        user.setDataNascimento(userEntity.getDataNascimento());
        return user;
    }
}
