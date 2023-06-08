package com.example.OWProjekat.controller;

import com.example.OWProjekat.model.dto.CreateUserDTO;
import com.example.OWProjekat.model.entity.User;
import com.example.OWProjekat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /*@GetMapping("/")
    public String home(Model model) {
        return "home";
    }*/

    @RequestMapping("/")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home.html");
        return modelAndView;
    }

    @RequestMapping("/info")
    public ModelAndView info(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("info.html");
        return modelAndView;
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping(value = "/register", consumes = "application/json")
    public ResponseEntity<User> Register(@RequestBody CreateUserDTO userDTO) {
        User user = userService.createUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/info")
    public String info(Model model) {return "info"; }

    @GetMapping("/appointment")
    public String appointment (Model model) {return  "appointment"; }
}
