package com.devtrack.service;

import com.devtrack.dto.CreateUserRequest;
import com.devtrack.dto.UserResponse;
import com.devtrack.entity.User;
import com.devtrack.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(CreateUserRequest request) {



            User user = new User();

            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setPhoneNumber(request.getPhoneNumber());
            user.setCollege(request.getCollege());
            user.setBranch(request.getBranch());
            user.setYear(request.getYear());

            User savedUser = userRepository.save(user);

            UserResponse response = new UserResponse();

            response.setId(savedUser.getId());
            response.setName(savedUser.getName());
            response.setEmail(savedUser.getEmail());
            response.setPhoneNumber(savedUser.getPhoneNumber());
            response.setCollege(savedUser.getCollege());
            response.setBranch(savedUser.getBranch());
            response.setYear(savedUser.getYear());

            return response;
        }


    public List<User> createUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User updatedUser) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        existingUser.setCollege(updatedUser.getCollege());
        existingUser.setBranch(updatedUser.getBranch());
        existingUser.setYear(updatedUser.getYear());

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(existingUser);
    }

}