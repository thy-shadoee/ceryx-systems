package service;

import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.Officer;
import model.Student;
import model.User;

/**
 * StudentManager
 */
public class UserManager {
  private final CredentialsValidator validator = new CredentialsValidator();
  private List<User> users = new ArrayList<>();
  private int nextId = 1;
  private User currentUser;

  public UserManager() {
    // Demo Accounts
    users.add(new Officer(nextId++, "officer", "officer1234"));
    users.add(new Admin(nextId++, "admin", "admin1234"));
  }

  public User getCurrentUser() {
    return currentUser;
  }

  private User findUserbyUsername(String username) {
    for (User user: users) {
      if (user.getUsername().equals(username)) {
        return user;
      }
    }
    return null;
  }

  public boolean register(String username, String password) {
    String cleanUsername = validator.cleanUsername(username);
    if (!validator.isValidUsername(cleanUsername)) {
      System.out.println("Registration failed: Username must not be empty.");
      return false;
    }

    if (!validator.isValidPassword(password)) {
      System.out.println("Registration failed: Password must have at least eight (8) characters.");
      return false;
    }

    if (findUserbyUsername(cleanUsername) != null) {
      System.out.println("Registration failed: This username is already taken.");
      return false;
    }

    users.add(new Student(nextId, username, password));
    nextId++;
    return true;
  }

  public boolean login(String username, String password) {
    User user = findUserbyUsername(validator.cleanUsername(username));
    if (user != null && user.matchesPassword(password)) {
      currentUser = user;
      return true;
    }

    return false;
  }

  public void logout() {
    this.currentUser = null;
  }
}

