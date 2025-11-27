package com.learn.pro1.controller;


import com.learn.pro1.dto.request.LoginRequest;
import com.learn.pro1.dto.request.RegisterRequest;
import com.learn.pro1.dto.response.AuthResponse;
import com.learn.pro1.entity.User;
import com.learn.pro1.mapper.AuthMapper;
import com.learn.pro1.repository.UserRepository;
import com.learn.pro1.response.ApiResponse;
import com.learn.pro1.security.CustomUserDetailsService;
import com.learn.pro1.security.JwtUtils;
import com.learn.pro1.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final CustomUserDetailsService userDetailsService;
    private final AuthMapper authMapper;
    private final AuthService authService;

    public AuthController(AuthenticationManager authManager, UserRepository userRepo,
                          PasswordEncoder passwordEncoder, JwtUtils jwtUtils,
                          CustomUserDetailsService userDetailsService, AuthMapper authMapper, AuthService authService) {
        this.authManager = authManager;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
        this.authMapper = authMapper;
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<ApiResponse<?>> register(@RequestBody RegisterRequest req){

        AuthResponse auth =  authService.createUser(req);

        if(auth == null){
            return ResponseEntity.badRequest().body(new ApiResponse<>(false,"User already exists",null));
        }

        return ResponseEntity.ok(new ApiResponse<>(true,"User registered successfully",auth));

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req){

        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            req.getRole(),
                            req.getPassword()
                    )
            );


            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            String token = jwtUtils.generateToken(userDetails.getUsername());


            return ResponseEntity.ok(new ApiResponse<>(true,"Login successful",Map.of("token",token)));
        }
        catch (AuthenticationException e){
            return ResponseEntity.badRequest().body(new ApiResponse<>(false,"Invalid credentials",null));
        }
    }









//    @PostMapping("/register")
//    public ResponseEntity<ApiResponse<AuthResponse>> register(@RequestBody RegisterRequest req) {
//
//        // 1. Check if email already exists
//        if (userRepo.existsByEmail(req.getEmail())) {
//            return ResponseEntity.badRequest().body(
//                    new ApiResponse<>(false, "Email already exists", null)
//            );
//        }
//
//        // 2. Check if username already exists (if you have username field)
//        if (userRepo.existsByUsername(req.getUsername())) {
//            return ResponseEntity.badRequest().body(
//                    new ApiResponse<>(false, "Username already exists", null)
//            );
//        }
//
//        // 3. Create new user
//        User user = new User();
//        user.setEmail(req.getEmail());
//        user.setUsername(req.getUsername());
//        user.setPassword(passwordEncoder.encode(req.getPassword()));
//        user.setRole("ROLE_USER");
//        userRepo.save(user);
//
//        // 4. Generate JWT token
//        String token = jwtUtils.generateToken(
//                userDetailsService.loadUserByUsername(user.getEmail())
//        );
//
//        // 5. Build response
//        AuthResponse auth = new AuthResponse();
//        auth.setEmail(user.getEmail());
//        auth.setToken(token);
//
//        return ResponseEntity.ok(
//                new ApiResponse<>(true, "User registered successfully", auth)
//        );
//    }
//
//
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
//        try {
//            Authentication authentication = authManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
//            );
//            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//            String token = jwtUtils.generateToken(userDetails);
//            return
//        } catch (AuthenticationException ex) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//        }
//    }



}
