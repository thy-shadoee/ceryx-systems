package model;

import java.util.List;

public class Student extends User {
  public Student(int id, String username, String password) {
    super(id, username, password, Role.STUDENT);
  }

  @Override
  public List<MenuItem> getMenuItems(MenuActionFactory factory) {
    return List.of(
        factory.viewAnnouncements(),
        factory.accountDetails(),
        factory.logout()
        );
  }
}
