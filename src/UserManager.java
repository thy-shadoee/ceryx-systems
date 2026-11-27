import java.util.ArrayList;
import java.util.List;

/**
 * StudentManager
 */
public class UserManager {
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
    if (username == null || username.trim().isEmpty()) {
      System.out.println("Registration failed: Username must not be empty.");
      return false;
    }

    username = username.trim();

    if (password == null || password.length() < 8) {
      System.out.println("Registration failed: Password must have at least eight (8) characters.");
      return false;
    }

    if (findUserbyUsername(username) != null) {
      System.out.println("Registration failed: This username already exists.");
      return false;
    }

    users.add(new Student(nextId, username, password));
    nextId++;
    return true;
  }

  public boolean login(String username, String password) {
    String trimmedUsername = username == null ? "" : username.trim();
    User user = findUserbyUsername(trimmedUsername);
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

