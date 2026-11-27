package model;

import java.util.List;

public abstract class User {
  private final int id;
  private final String username;
  private String password;
  private final Role role;

  protected User(int id, String username, String password, Role role) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.role = role;
  }

  public int getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public Role getRole() {
    return role;
  }

  public boolean matchesPassword(String password) {
    return this.password.equals(password);
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public abstract List<MenuItem> getMenuItems(MenuActionFactory factory);
}
