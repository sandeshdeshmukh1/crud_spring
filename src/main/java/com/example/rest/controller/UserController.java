package com.example.rest.controller;

import com.example.rest.entity.User;
import com.example.rest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userServices;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userServices.getUserList());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return ResponseEntity.ok().body(this.userServices.getUserById(id));
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok().body(this.userServices.createUser(user));
    }

    @PostMapping("/addUsers")
    public ResponseEntity<List<User>> addUsers(@RequestBody List<User> list) {
        return ResponseEntity.ok().body(this.userServices.createUserList(list));
    }
    @PutMapping("/editUser")
    public ResponseEntity<User> editUser(@RequestBody User user) {
        return ResponseEntity.ok().body(this.userServices.updateUserById(user));
    }
    @DeleteMapping("/deleteUser/{id}")
    public HttpStatus deleteUser(@PathVariable int id){
        this.userServices.deleteUserById(id);
        return HttpStatus.OK;
    }


}
