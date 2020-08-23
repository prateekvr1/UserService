package dev.prateek.userservice.controller;

import dev.prateek.userservice.dto.ResponseDto;
import dev.prateek.userservice.dto.UserResponseDto;
import dev.prateek.userservice.dto.Userdto;
import dev.prateek.userservice.model.User;
import dev.prateek.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {
    @Autowired
    private UserService userService;
    @PostMapping("/user/register")
    public ResponseDto<UserResponseDto>registerUser(@RequestBody Userdto userdto){
        User user=userService.registerUser(userdto);
     return new ResponseDto<>(HttpStatus.OK,
             new UserResponseDto(user.getId(),user.getFullname(),user.getEmail(),user.isActive()));
    }
    @GetMapping("/user/confirm")
    public ResponseDto<UserResponseDto> validateUser(@RequestParam String verificationToken)
    {
        userService.

    }

}
