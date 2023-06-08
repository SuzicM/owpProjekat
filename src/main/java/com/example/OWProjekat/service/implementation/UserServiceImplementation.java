package com.example.OWProjekat.service.implementation;

import com.example.OWProjekat.model.dto.CreateUserDTO;
import com.example.OWProjekat.model.dto.UpdateUserDTO;
import com.example.OWProjekat.model.entity.Roles;
import com.example.OWProjekat.model.entity.User;
import com.example.OWProjekat.repository.UserRepository;
import com.example.OWProjekat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findByJmbg(String jmbg) {
        return userRepository.findByJmbg(jmbg);
    }

    @Override
    public User createUser(CreateUserDTO userDTO) {

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setJmbg(userDTO.getJmbg());
        user.setPhone(userDTO.getPhone());
        user.setRole(Roles.USER);

        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(UpdateUserDTO updateUserDTO, String username) {

        User updatedUser = userRepository.findByJmbg(username);

        if (updateUserDTO.getFirstName() != null) { updatedUser.setFirstName(updateUserDTO.getFirstName());}

        if (updateUserDTO.getLastName() != null) { updatedUser.setLastName(updateUserDTO.getLastName());}

        if (updateUserDTO.getEmail() != null) { updatedUser.setEmail(updateUserDTO.getEmail());}

        if (updateUserDTO.getJmbg() != null) { updatedUser.setJmbg(updateUserDTO.getJmbg());}

        if (updateUserDTO.getPhone() != null) { updatedUser.setPhone(updateUserDTO.getPhone());}

        userRepository.updateUser(updatedUser.getFirstName(),
                                  updatedUser.getLastName(),
                                  updatedUser.getEmail(),
                                  updatedUser.getJmbg(),
                                  updatedUser.getPhone(),
                                  updatedUser.getId());
        return updatedUser;
    }

    @Override
    public User changePassword(String newPassword, String username) {
        return null;
    }

    @Override
    public Boolean oldPasswordVerification(String oldPassword, String username) {
        return null;
    }
}



