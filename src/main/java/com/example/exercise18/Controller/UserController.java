package com.example.exercise18.Controller;


import com.example.exercise18.Model.User;
import com.example.exercise18.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/post")
    public ResponseEntity addUser(@Valid @RequestBody User user , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @Valid @RequestBody User user , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.updateUser(id, user);
        return ResponseEntity.status(200).body("user updated successfully");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("user deleted successfully");

    }

    @GetMapping("login/{username}/{password}")
    public ResponseEntity login(@PathVariable String username, @PathVariable String password) {
        User user = userService.loginUser(username, password);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("byemail/{email}")
    public ResponseEntity findByEmail(@PathVariable String email) {
        User user = userService.getByEmail(email);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("byrole/{role}")
    public ResponseEntity findByRole(@PathVariable String role) {
        List<User> user = userService.getByRole(role);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/byage/{age}")
    public ResponseEntity findByAge(@PathVariable Integer age) {
        List<User> user = userService.getByAge(age);
        return ResponseEntity.status(200).body(user);
    }




}
