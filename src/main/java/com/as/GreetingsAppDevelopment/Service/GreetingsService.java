package com.as.GreetingsAppDevelopment.Service;
import org.springframework.stereotype.Service;

@Service
public class GreetingsService {
    public String getGreetingMessage() {
        return "Hello World";
    }
}