package com.example.demo.api;

import com.example.demo.model.UserModel;
import com.example.demo.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserModelApi {

    private final MyUserService myUserService;

    @GetMapping
    public String get123(){
        return "test";
    }

    @PostMapping("/registr")
    public void registr(@RequestBody UserModel model){
        myUserService.registr(model);
    }
}