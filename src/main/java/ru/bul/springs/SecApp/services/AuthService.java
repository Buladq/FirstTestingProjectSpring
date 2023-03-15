package ru.bul.springs.SecApp.services;

import org.springframework.stereotype.Service;
import ru.bul.springs.SecApp.models.Person;
import ru.bul.springs.SecApp.repository.PeopleRepository;

import java.util.Optional;

@Service
public class AuthService {
    private final PeopleRepository peopleRepository;

    public AuthService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


    public boolean login(String login,String password){
        Optional<Person> wh=peopleRepository.findByUsername(login);

        if(wh.isPresent()){
            return wh.get().getPassword().equals(password);

        }
        return false;
    }
}
