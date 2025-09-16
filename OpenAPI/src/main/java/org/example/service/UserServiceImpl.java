package org.example.service;

import com.example.demo.generated.model.UserRequest;
import com.example.demo.generated.model.UserResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class UserServiceImpl implements UserService {

    private final Map<Long, UserResponse> users = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    @Override
    public UserResponse createUser(UserRequest request) {
        int id = (int) counter.incrementAndGet();
        UserResponse user = new UserResponse();
        user.setId(id);
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        users.put((long) id, user);
        return user;
    }

    @Override
    public UserResponse getUserById(Long id) {
        return users.get(id);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        UserResponse user = users.get(id);
        if (user != null) {
            user.setName(request.getName());
            user.setEmail(request.getEmail());
        }
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        users.remove(id);
    }
}
