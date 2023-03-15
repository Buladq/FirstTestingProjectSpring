package ru.bul.springs.SecApp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/testing")
public class HelloContorller {

    @GetMapping("/here")
    public String succes(){
        return "hello";
    }
}
