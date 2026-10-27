package com.korah.learning;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserResource {

  @Inject
  UserService userService;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response register(RegisterRequest request) {
    User created = userService.registerUser(request.email, request.passwordHash);
    return Response.status(Response.Status.CREATED)
            .entity(new UserResponse(created.getId(), created.getEmail()))
            .build();
  }

  public static class RegisterRequest {
    public String email;
    public String passwordHash;  // We'll hash this properly in Stage 8
  }

  public static class UserResponse {
    public Long id;
    public String email;

    public UserResponse() {}
    public UserResponse(Long id, String email) {
      this.id = id;
      this.email = email;
    }
  }
}