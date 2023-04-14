package com.example.OWProjekat.service;

import com.example.OWProjekat.model.dto.CreateUserDTO;
import com.example.OWProjekat.model.dto.UpdateUserDTO;
import com.example.OWProjekat.model.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User findUserById(long id);

    User findByJmbg(String jmbg);

    User createUser(CreateUserDTO userDTO);

    User updateUser(UpdateUserDTO updateUserDTO, String username);

    User changePassword(String newPassword, String username);

    Boolean oldPasswordVerification(String oldPassword, String username);



}
