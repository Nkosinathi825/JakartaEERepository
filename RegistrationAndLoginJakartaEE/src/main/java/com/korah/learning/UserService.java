package com.korah.learning;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserService {

  @Inject
  UserRepository userRepository;

  @Transactional
  public User registerUser(String email, String passwordHash) {
    User user = new User(email, passwordHash);
    userRepository.save(user);
    return user;
  }
}