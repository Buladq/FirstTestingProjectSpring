package ru.bul.springs.SecApp.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.bul.springs.SecApp.models.Person;
import ru.bul.springs.SecApp.services.AuthService;
import ru.bul.springs.SecApp.services.RegistrationService;


import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {


    private final RegistrationService registrationService;

    private final AuthService authService;



    public AuthController(RegistrationService registrationService, AuthService authService) {

        this.registrationService = registrationService;
        this.authService = authService;
    }

    @GetMapping("/login")
    public String loginPage(){

        return "auth/login";

    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person){
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person")@Valid Person person,
                                      BindingResult bindingResult){


        if(bindingResult.hasErrors()){
            return "auth/registration";
        }

        registrationService.registred(person);



        return "redirect:/auth/login";
    }

    @PostMapping("/logout")
    public String performLogout(Authentication authentication) throws Exception {

        if (authentication != null) {
            // Очищаем данные аутентификации
            authentication.setAuthenticated(false);
        }
        else {
            throw new Exception("nothing to logut");
        }
        // Перенаправляем на страницу логина
        return "redirect:/login";
    }





}
