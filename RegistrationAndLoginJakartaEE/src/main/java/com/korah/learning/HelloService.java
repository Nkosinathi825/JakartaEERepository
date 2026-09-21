package com.korah.learning;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class HelloService {
  private long callCount = 0;

  public String greet(String name) {
    callCount++;
    System.out.println("HelloService call #" + callCount);
    if (name == null || name.isBlank()) {
      return "Hello, World";
    }
    return "Hello, " + name;
  }
}
