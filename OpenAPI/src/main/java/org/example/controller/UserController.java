package org.example.controller;

import com.example.demo.generated.api.UserApi;
import com.example.demo.generated.model.UserRequest;
import com.example.demo.generated.model.UserResponse;
import org.example.service.UserService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UserController implements UserApi {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<List<UserResponse>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<Void> deleteUser(Integer id) {
        userService.deleteUser(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserResponse> getUserById(Integer id) {
        UserResponse user = userService.getUserById(Long.valueOf(id));
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<UserResponse> updateUser(Integer id, UserRequest request) {
        UserResponse user = userService.updateUser(Long.valueOf(id), request);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<UserResponse> createUser(UserRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }
}
