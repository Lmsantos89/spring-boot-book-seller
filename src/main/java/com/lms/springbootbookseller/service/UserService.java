package com.lms.springbootbookseller.service;

import com.lms.springbootbookseller.model.User;
import com.lms.springbootbookseller.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.lms.springbootbookseller.model.Role.ADMIN;
import static com.lms.springbootbookseller.model.Role.USER;
import static java.time.LocalDateTime.now;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(USER);
        user.setCreateTime(now());

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Transactional
    @Override
    public void makeAdmin(String username){
        userRepository.updateUserRole(username, ADMIN);
    }
}
