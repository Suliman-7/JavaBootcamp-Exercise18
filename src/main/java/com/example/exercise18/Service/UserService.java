package com.example.exercise18.Service;

import com.example.exercise18.Api.ApiException;
import com.example.exercise18.Model.User;
import com.example.exercise18.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.pleaseGetAllUsers();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Integer id , User user) {
        User u = userRepository.findById(id);

        if (u == null) {
            throw new ApiException("User not found");
        }
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setAge(user.getAge());
        u.setEmail(user.getEmail());
        u.setRole(user.getRole());
        u.setUsername(user.getUsername());
        userRepository.save(u);

    }

    public void deleteUser(Integer id) {
        User u = userRepository.findById(id);
        if (u == null) {
            throw new ApiException("User not found");
        }
        userRepository.delete(u);
    }

    public User loginUser(String username, String password) {
        User user = userRepository.LogIn(username,password);

        if (user == null) {
            throw new ApiException("User not found");
        }
        return user;
    }

    public User getByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new ApiException("User not found");
        }
        return user;
    }

    public List<User> getByRole(String role) {
        List<User> users = userRepository.pleaseGetByRole(role);
        if (users.isEmpty()) {
            throw new ApiException("User not found");
        }
        return users;
    }

    public List<User> getByAge(int age) {
        List<User> users = userRepository.pleaseGetByAge(age);

        if (users.isEmpty()) {
            throw new ApiException("User not found");
        }
        return users;
    }










}
