package com.as.GreetingsAppDevelopment.Controller;

import com.as.GreetingsAppDevelopment.Service.GreetingsService;
import com.as.GreetingsAppDevelopment.models.Greetings;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
@RestController
@RequestMapping("/greeting")
public class GreetingsController {
    private final GreetingsService greetingsService;

    public GreetingsController(GreetingsService greetingsService){
        this.greetingsService=greetingsService;
    }

    //UC5
    @GetMapping("/{id}")
    public Greetings getGreetingById(@PathVariable Long id) {
        return greetingsService.getGreetingById(id);
    }
   //UC4
    @PostMapping("/save")
    public Greetings  savesGreeting(@RequestBody Greetings greetings) {
        return greetingsService.saveGreetingMessage(greetings.getMessage());
    }

    //UC3
    @GetMapping("/firstNameLastName")
    public String getGreeting(@RequestParam(required = false)String firstName,@RequestParam(required = false)String lastName){
        return greetingsService.getGreetingMessage(firstName, lastName);
    }

    //UC2
    @GetMapping("/empty")
    public String getGreeting(){
        return greetingsService.getGreetingMessage();
    }
    //UC1
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
    @GetMapping("/all")
    public List<Greetings> getAllGreetings() {
        return greetingsService.getAllGreetings();
    }
    @PutMapping("/id/{id}")
    public Greetings updateGreeting(@PathVariable Long id, @RequestBody Greetings greetings){
        return greetingsService.updateGreeting(id,greetings.getMessage());
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteGreeting(@PathVariable Long id){
        greetingsService.deleteGreeting(id);
        return ResponseEntity.ok("Greeting deleted Successfully");
    }
}
