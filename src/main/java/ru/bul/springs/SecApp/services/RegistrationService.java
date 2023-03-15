package ru.bul.springs.SecApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bul.springs.SecApp.models.Person;
import ru.bul.springs.SecApp.repository.PeopleRepository;

@Service
public class RegistrationService {

    private final PeopleRepository peopleRepository;


    @Autowired
    public RegistrationService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;

    }


    @Transactional
    public void registred(Person person){
         person.setRole("ROLE_USER");
        peopleRepository.save(person);
    }
}
