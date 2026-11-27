package model;

public class Officer extends User {
  public Officer(int id, String username, String password) {
    super(id, username, password, Role.OFFICER);
  }
}
