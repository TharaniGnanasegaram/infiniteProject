package com.example.infiniteOS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/infiniteUser")
public class UsersController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Users> get(@PathVariable Integer id) {
        try {
            Users user = userService.getUser(id);
            return new ResponseEntity<Users>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
        }
    }


    @CrossOrigin
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody Users user) {
        System.out.print("Log " + user.toString());
        userService.saveUser(user);
    }


    @CrossOrigin
    @GetMapping("/login")
    public ResponseEntity<Users> loginUser(@RequestParam String username, @RequestParam String password){

        Users user = userService.loginUser(username, password);
        return new ResponseEntity<Users>(user, HttpStatus.OK);
    }
}
