package com.as.GreetingsAppDevelopment.Service;
import org.springframework.stereotype.Service;

@Service
public class GreetingsService {
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
}
