package com.korah.learning;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

@ApplicationScoped
public class UserRepository {

  @PersistenceContext(unitName = "userPU")
  private EntityManager entityManager;

  public void save(User user) {
    entityManager.persist(user);
  }

  public Optional<User> findById(Long id) {
    return Optional.ofNullable(entityManager.find(User.class, id));
  }

  public Optional<User> findByEmail(String email) {
    TypedQuery<User> query = entityManager.createQuery(
            "SELECT u FROM User u WHERE u.email = :email", User.class);
    query.setParameter("email", email);
    return query.getResultStream().findFirst();
  }
}