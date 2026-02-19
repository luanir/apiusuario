package com.luan.apiusuarios.controller;

import com.luan.apiusuarios.dto.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                		 request.email(),
                         request.password()
                );

        Authentication authentication =
                authenticationManager.authenticate(authToken);

        return ResponseEntity.ok("Login efetuado com sucesso");
    }
}
