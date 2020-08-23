package dev.prateek.userservice.service;

import dev.prateek.userservice.dto.Userdto;
import dev.prateek.userservice.model.User;

public interface UserService {
public User registerUser(Userdto userdto);
public User validateUser(String token);
}
