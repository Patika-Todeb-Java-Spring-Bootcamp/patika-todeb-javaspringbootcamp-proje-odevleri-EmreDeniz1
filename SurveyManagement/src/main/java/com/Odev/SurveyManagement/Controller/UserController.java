package com.Odev.SurveyManagement.Controller;

import com.Odev.SurveyManagement.Entity.User;
import com.Odev.SurveyManagement.Service.UserService;
import com.Odev.SurveyManagement.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

        @PostMapping("/create")
        public ResponseEntity create (@RequestBody UserDTO user) {
            User newUser = userService.createNewUser(user);
            if(newUser == null)
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                        body("User Creation Not Succesful");
            return ResponseEntity.status(HttpStatus.OK).body(newUser);
        }

        @GetMapping("/all")
        public ResponseEntity getAll(){
            List<User> users = userService.All();
            return ResponseEntity.ok(users);
        }

        @GetMapping("/{id}")
        public ResponseEntity findById (@PathVariable Long id) {
            User user;
            try {
                user = userService.fromId(id);
            }catch (RuntimeException exception) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
                return ResponseEntity.status(HttpStatus.OK).body(user);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity delete (@PathVariable Long id) {
            userService.deleteId(id);
            return ResponseEntity.status(HttpStatus.OK).body("User deletion is complate");
        }
}
