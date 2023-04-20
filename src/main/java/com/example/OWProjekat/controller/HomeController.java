package com.example.OWProjekat.controller;

import com.example.OWProjekat.model.dto.CreateUserDTO;
import com.example.OWProjekat.model.entity.User;
import com.example.OWProjekat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping(value = "/register", consumes = "application/json")
    public ResponseEntity<User> Register(@RequestBody CreateUserDTO userDTO) {
        User user = userService.createUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/info")
    public String info(Model model) {return "info"; }

    @GetMapping("/appointment")
    public String appointment (Model model) {return  "appointment"; }
}
