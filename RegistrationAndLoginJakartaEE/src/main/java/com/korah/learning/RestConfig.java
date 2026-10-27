package com.korah.learning;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class RestConfig extends Application {

  // Leaving this empty means im allowing the default auto-discovery of the classes annotated
  // with @Path
}
