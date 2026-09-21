package com.korah.learning;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class StartupListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("=====================================");
    System.out.println("  Hello World from user-app!");
    System.out.println("  The application has started.");
    System.out.println("=====================================");
  }
  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("=====================================");
    System.out.println("  user-app is shutting down. Goodbye.");
    System.out.println("=====================================");
  }
}