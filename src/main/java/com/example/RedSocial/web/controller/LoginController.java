package com.example.RedSocial.web.controller;


import com.example.RedSocial.domain.security.JWTAuthtenticationConfig;
import com.example.RedSocial.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @PostMapping("login")
    public User login(
            @RequestParam("user") String username,
            @RequestParam("encryptedPass") String encryptedPass) {

        /**
         * En el ejemplo no se realiza la correcta validación del usuario
         */

        String token = jwtAuthtenticationConfig.getJWTToken(username);
        return new User(username, encryptedPass, token);

    }

}