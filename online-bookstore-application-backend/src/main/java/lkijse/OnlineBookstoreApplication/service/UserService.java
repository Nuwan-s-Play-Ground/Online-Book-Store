package lkijse.OnlineBookstoreApplication.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lkijse.OnlineBookstoreApplication.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User newUser) {
        // Check if the username is already taken
        if (userRepository.existsByUsername(newUser.getUsername())) {
            // Handle the case where the username is already taken
            // You can throw a custom exception or return null/error response
            return null;
        }

        // Encode the user's password before saving it to the database
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        // Save the new user to the database
        return userRepository.save(newUser);
    }

    public User updateUser(Long id, User updatedUser) {
        // Find the user by ID
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            // Handle the case where the user is not found
            // You can throw a custom exception or return null/error response
            return null;
        }

        User existingUser = optionalUser.get();

        // Update user attributes as needed
        existingUser.setUsername(updatedUser.getUsername());
        // You can update other attributes such as email, roles, etc.

        // Save the updated user to the database
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public boolean isUsernameTaken(Object username) {
        return false;
    }
}
