package com.Odev.SurveyManagement.Service;

import com.Odev.SurveyManagement.Entity.Role;
import com.Odev.SurveyManagement.Entity.SurveyManager;
import com.Odev.SurveyManagement.Exception.CustomJwtException;
import com.Odev.SurveyManagement.Exception.EntityNotFoundException;
import com.Odev.SurveyManagement.Repository.SurveyManagerRepository;
import com.Odev.SurveyManagement.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
        import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyManagerService {

    private final SurveyManagerRepository surveyManagerRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManager authenticationManager;

    public List<SurveyManager> getAll() {
        return surveyManagerRepository.findAll();
    }

    public String signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, surveyManagerRepository.findByUsername(username).getRoles());
        } catch (AuthenticationException e) {
            throw new CustomJwtException("Invalid username/password supplied", HttpStatus.BAD_REQUEST);
        }
    }

    public String signup(SurveyManager user, boolean isAdmin) {
        if (!surveyManagerRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Role role = isAdmin ? Role.ROLE_ADMIN : Role.ROLE_CLIENT;
            user.setRoles(Collections.singletonList(role));
            surveyManagerRepository.save(user);
            return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
        } else {
            throw new CustomJwtException("Username is already in use", HttpStatus.BAD_REQUEST);
        }
    }

    public void delete(String username) {
        SurveyManager byUsername = surveyManagerRepository.findByUsername(username);
        if (byUsername == null) {
            throw new EntityNotFoundException("User", "username : " + username);
        } else if (byUsername.getRoles().contains(Role.ROLE_ADMIN)) {
            throw new AccessDeniedException("No permission to delete user : " + username);
        }
        surveyManagerRepository.deleteByUsername(username);
    }

    public SurveyManager search(String username) {
        SurveyManager user = surveyManagerRepository.findByUsername(username);
        if (user == null) {
            throw new CustomJwtException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return user;
    }



}
