package com.as.GreetingsAppDevelopment.Service;
import com.as.GreetingsAppDevelopment.Repository.GreetingRepository;
import com.as.GreetingsAppDevelopment.models.Greetings;
import org.springframework.stereotype.Service;

@Service
public class GreetingsService {
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
}
