package com.br.symbee.symbee.services.impl;

import com.br.symbee.symbee.domain.User;
import com.br.symbee.symbee.entities.UserEntity;
import com.br.symbee.symbee.repository.UserRepository;
import com.br.symbee.symbee.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(User::convertToUser).toList();
    }

    @Override
    public void create(User user) {
        UserEntity userEntity = new UserEntity();

        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setDataNascimento(user.getDataNascimento());
        userEntity.setCpf(user.getCpf());

        userRepository.save(userEntity);
    }

    @Override
    public String login(String email, String password) throws Exception {
        UserEntity userEntity = userRepository.findByEmail(email);

        if(userEntity == null || !userEntity.getPassword().equals(password)) {
            throw new Exception("E-mail ou senha inválido.");
        }
        return userEntity.getEmail();
    }
}
