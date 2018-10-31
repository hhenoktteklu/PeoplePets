package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.entity.Pet;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PetRepository petRepository;

    @GetMapping("/")
    public String homePage(Model model){

        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Dav");

        Pet pet1 = new Pet();
        pet1.setPetName("Jack -> Dog");
        pet1.setPerson(person);

        Pet pet2 = new Pet();
        pet2.setPetName("Simb -> Cat");
        pet2.setPerson(person);

        Set<Pet> pets = new HashSet<Pet>();
        pets.add(pet1);
        pets.add(pet2);

        person.setPets(pets);

        personRepository.save(person);
        petRepository.save(pet1);
        petRepository.save(pet2);
        personRepository.save(person);

        model.addAttribute("persons", personRepository.findAll());

        return "homepage";
    }
}
