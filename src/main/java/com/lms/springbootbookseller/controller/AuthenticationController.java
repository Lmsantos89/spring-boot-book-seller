package com.lms.springbootbookseller.controller;

import com.lms.springbootbookseller.model.User;
import com.lms.springbootbookseller.service.IAuthenticationService;
import com.lms.springbootbookseller.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IUserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<User> singUp(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return new ResponseEntity<>(CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(user), CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<User> signIn(@RequestBody User user) {
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
    }
}
