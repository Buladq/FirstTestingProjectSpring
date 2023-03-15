package ru.bul.springs.SecApp.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.bul.springs.SecApp.models.Person;
import ru.bul.springs.SecApp.repository.PeopleRepository;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class AddedUserTest {

   @Autowired
    private RegistrationService reg;

    @Autowired
    private PeopleRepository peopleRepository;




    @Test
    void registred() {
        Person person=new Person("FromTest2","pass123","ROLE_USER");
        reg.registred(person);
        Person whatYouWaitFor=(peopleRepository.findAll().get(peopleRepository.findAll().size()-1));
        assertEquals(person,whatYouWaitFor);




    }






}