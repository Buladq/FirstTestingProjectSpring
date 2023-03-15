package ru.bul.springs.SecApp.services;


import org.springframework.stereotype.Service;
import ru.bul.springs.SecApp.models.Person;
import ru.bul.springs.SecApp.repository.PeopleRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {


    private final PeopleRepository peopleRepository;

    public PersonService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }




    public List<Person> all(){
        return peopleRepository.findAll();
    }

    public Person byId(int id){
        Optional<Person> foundperson= peopleRepository.findById(id);
        return foundperson.get();
    }

    public Optional<Person> FindByName(String name){
        return peopleRepository.findByUsername(name);
    }


    public Boolean isTherePerson(String name){
        return peopleRepository.findByUsername(name).isPresent();
    }



}
