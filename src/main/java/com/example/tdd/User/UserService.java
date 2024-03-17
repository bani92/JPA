package com.example.tdd.User;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    public List<UserReponse> findAll() {
        return new ArrayList<>();
    }

    public UserReponse signUp(SignUpRequest request) {
        return null;
    }
}
