package com.reactive.user.controller;

import com.reactive.user.domain.User;
import com.reactive.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@AllArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private UserService userService;

    @PostMapping("/")
    public Mono<User> addUser(@Valid @RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @GetMapping("/")
    public Flux<User> getUsers() {
        return userService.getUsers();
    }
}
