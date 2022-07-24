package com.surveyMane.surveyManag.Controller;

import com.surveyMane.surveyManag.Service.userService;
import com.surveyMane.surveyManag.dto.UserDto;
import com.surveyMane.surveyManag.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    private userService userService;

    public userController(userService UserService){
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @PostMapping("/create")
    public ResponseEntity createnewUser(@RequestBody UserDto newUser) {
        User user = userService.makeNewUser(newUser);
        if(user == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("User not created");
        }
       return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity findById (@PathVariable Long userId) {
        User user;
        try {
            user = userService.findUser(userId);
        }catch (RuntimeException exception){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateuser(@PathVariable("id") Long id, @RequestBody UserDto userInfo) {
        User user = userService.updateById(id, userInfo);
        if(user == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User update failed");
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteCourse(@RequestParam(name = "userId") Long id) {
        try {
            userService.delete(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Related Course deleted successfully");
    }

}
