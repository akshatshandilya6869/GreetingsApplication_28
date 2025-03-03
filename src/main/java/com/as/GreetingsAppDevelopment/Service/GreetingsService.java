package com.as.GreetingsAppDevelopment.Service;
import com.as.GreetingsAppDevelopment.Repository.GreetingRepository;
import com.as.GreetingsAppDevelopment.models.Greetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class GreetingsService {
    @Autowired
    private final GreetingRepository greetingRepository;

    public GreetingsService(GreetingRepository greetingRepository){
        this.greetingRepository=greetingRepository;
    }
    public String getGreetingMessage() {
        return "Hello World";
    }

    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName;
        } else if (firstName != null) {
            return "Hello " + firstName;
        } else if (lastName != null) {
            return "Hello " + lastName;
        } else {
            return "Hello World";
        }
    }
    //UC4
    public Greetings saveGreetingMessage(String message){
//        String Greetings=new Greetings(message);
        return greetingRepository.save(new Greetings(message));
    }
    public Greetings getGreetingById(Long id){
        return greetingRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Couldn't find greeting with id" + id));
    }
    public List<Greetings> getAllGreetings(){
        return greetingRepository.findAll();
    }
    public Greetings updateGreeting(Long id,String newMessage){
        Optional<Greetings> existingGreeting = greetingRepository.findById(id);
        if(existingGreeting.isPresent()){
            Greetings greetings=existingGreeting.get();
            greetings.setMessage(newMessage);
            return greetingRepository.save(greetings);
        }
        throw new RuntimeException(("Greeting with Id " + id +"not found"));
    }
    public void deleteGreeting(Long id){
        if(!greetingRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Greeting not found");
        }
        greetingRepository.deleteById(id);
    }
}
