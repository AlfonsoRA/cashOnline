package com.backend.cash.controller;

import com.backend.cash.model.User;
import com.backend.cash.modelDTO.UserDTO;
import com.backend.cash.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/")
    public ResponseEntity<?> save(@Valid @RequestBody User user){
        UserDTO userDTO = userService.userSave(user);
        return new ResponseEntity(userDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getId(@PathVariable  Long id){
        UserDTO userDTO = userService.findById(id);
        return new ResponseEntity(userDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteId(@PathVariable  Long id){
        userService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
