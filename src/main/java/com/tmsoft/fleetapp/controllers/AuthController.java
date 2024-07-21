package com.tmsoft.fleetapp.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.tmsoft.fleetapp.dto.LoginDto;
import com.tmsoft.fleetapp.dto.RegisterDto;
import com.tmsoft.fleetapp.models.UserEntity;
import com.tmsoft.fleetapp.models.UserRole;
import com.tmsoft.fleetapp.repositories.UserRepository;
import com.tmsoft.fleetapp.repositories.UserRoleRepository;
import com.tmsoft.fleetapp.services.UserRoleService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRoleService userRoleService;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
            UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        // List<UserRole> roleList = userRoleService.getRoles();

        // model.addAttribute("roles", roleList);
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new RegisterDto());
        }

        return "pages-register";
    }

    @PostMapping("register/save")
    public String register(@ModelAttribute("user") RegisterDto registerDto,
            BindingResult result,
            RedirectAttributes redirectAttributes) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            result.rejectValue("username", "error.username",
                    "Username already exits");
        }

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
            redirectAttributes.addFlashAttribute("user", registerDto);
            return "redirect:/register";
        }

        UserEntity user = new UserEntity();
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setUsername(registerDto.getUsername());
        UserRole role = userRoleRepository.findByDescription("USER").get();
        user.setRoles(Collections.singletonList(role));

        userRepository.save(user);
        return "redirect:/login?success";
    }

    @GetMapping("/login")
    public String showLoginPage(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "success", required = false) String success,
            Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "Invalid username or password.");
        }

        if (success != null) {
            model.addAttribute("successMessage", "Account Creation Successful");
        }
        return "pages-login";
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(),
                            loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "redirect:/index";
        } catch (AuthenticationException e) {
            // Log the exception for debugging
            System.out.println("Login failed: " + e.getMessage());
            return "redirect:/login?error";
        }
    }

    @PostMapping("/auth/logout")
    public String logout() {
        return "pages-login";
    }
}
