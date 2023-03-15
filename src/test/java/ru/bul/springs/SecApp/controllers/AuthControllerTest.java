package ru.bul.springs.SecApp.controllers;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BindingResult;

import ru.bul.springs.SecApp.models.Person;
import ru.bul.springs.SecApp.secutiry.PersonDetails;
import ru.bul.springs.SecApp.services.AuthService;
import ru.bul.springs.SecApp.services.RegistrationService;


import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;


import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.validation.constraints.AssertTrue;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {


    @Autowired
    private RegistrationService registrationService;



    @Autowired
    private AuthController authController;

    @Autowired
    private AuthService authService;






    @Test
    @DisplayName("должен упасть1")//регист.пользователя с пустым именем
    void performRegistration() {
        Person person=new Person("","fqwfqfqfq","");
        BindingResult result = mock(BindingResult.class);//класс для проверок аннотация
        authController.performRegistration(person, result);

    }

    @Test
    void performRegistrationTwo() {
        Person person=new Person("user88","user88","ROLE_USER");
        BindingResult result = mock(BindingResult.class);
        authController.performRegistration(person, result);
    }


    @Test
    @DisplayName("должен упасть2")
    void performRegistrationThree() { //пользователь с пустым паролем
        Person person=new Person("Symbols","");
        BindingResult result = mock(BindingResult.class);
        authController.performRegistration(person, result);
    }

    @Test
    void performRegistrationFour() {
        Person person=new Person("Symbols","Символ");
        BindingResult result = mock(BindingResult.class);
        authController.performRegistration(person, result);

    }

    @Test
    public void testLogout() throws Exception {
      Authentication authentication=new Authentication() { //имитация зашедшего пользователя
          @Override
          public Collection<? extends GrantedAuthority> getAuthorities() {
              return null;
          }

          @Override
          public Object getCredentials() {
              return null;
          }

          @Override
          public Object getDetails() {
              return null;
          }

          @Override
          public Object getPrincipal() {
              return null;
          }

          @Override
          public boolean isAuthenticated() {
              return false;
          }

          @Override
          public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

          }

          @Override
          public String getName() {
              return null;
          }
      };



       authController.performLogout(authentication);


    }



    @Test
    public void testLogout2() throws Exception {

        Authentication authentication= null; //делаю так,что пользовтаель не зашел

        authController.performLogout(authentication);


    }

    @Test
    public void testLoginPage() throws Exception {
      boolean r=authService.login("admin","admin");
        assertTrue(r);
    }

    @Test
    public void testLoginPage2() throws Exception {
        boolean r=  authService.login("afeqfqe","gewgqgkq");
        assertTrue(r);
    }







}