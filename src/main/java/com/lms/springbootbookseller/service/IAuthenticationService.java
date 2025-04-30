package com.lms.springbootbookseller.service;

import com.lms.springbootbookseller.model.User;

public interface IAuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
