package com.example.RESTAPI.service;

import com.example.RESTAPI.dto.UserRegDTO;
import com.example.RESTAPI.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegDTO registrationDto);
}
