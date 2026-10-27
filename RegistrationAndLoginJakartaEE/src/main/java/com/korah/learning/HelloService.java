package com.korah.learning;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class HelloService {

  @Inject
  UserRepository userRepository;

  public String greet(String name) {
    if (name == null || name.isBlank()) {
      return "Hello, World";
    }
    return "Hello, " + name;
  }

  public long countUsers() {
    // We'll replace this with a real count later; for now it's a readiness check
    return userRepository.findById(1L).map(u -> 1L).orElse(0L);
  }
}