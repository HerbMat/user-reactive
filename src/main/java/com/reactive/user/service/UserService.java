package com.reactive.user.service;

import com.reactive.user.domain.User;
import com.reactive.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Mono<User> getUser(String id) {
        log.debug("Retrieving user with id [{}] from database.", id);
        return userRepository.findById(id);
    }

    public Mono<User> addUser(User user) {
        log.debug("Adding new user [{}]", user);
       return userRepository.save(user);
    }

    public Flux<User> getUsers() {
        log.debug("Returning list of all users");
        return userRepository.findAll();
    }
}
