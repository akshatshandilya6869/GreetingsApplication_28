package com.as.GreetingsAppDevelopment.Controller;

import com.as.GreetingsAppDevelopment.Service.GreetingsService;
import com.as.GreetingsAppDevelopment.models.Greetings;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingsController {
    private final GreetingsService greetingsService;

    public GreetingsController(GreetingsService greetingsService){
        this.greetingsService=greetingsService;
    }

    @GetMapping
    public String getGreeting(){
        return greetingsService.getGreetingMessage();
    }

    @GetMapping("/{name}")
    public Greetings getGreeting(@PathVariable String name) {
        return new Greetings("Hello " + name);
    }

    @PostMapping
    public Greetings postGreeting(@RequestBody String name) {
        return new Greetings("Hello " + name + " from POST");
    }

    @PutMapping("/{name}")
    public Greetings putGreeting(@PathVariable String name) {
        return new Greetings("Hello " + name + " from PUT");
    }

    @DeleteMapping("/{name}")
    public Greetings deleteGreeting(@PathVariable String name) {
        return new Greetings("Goodbye " + name + " from DELETE");
    }
}
