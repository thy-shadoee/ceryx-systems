import java.util.List;

public class Officer extends User {
  public Officer(int id, String username, String password) {
    super(id, username, password, Role.OFFICER);
  }

  @Override
  public List<String> getMenuItems() {
    return List.of(
        "View Announcements",
        "Manage Announcements",
        "Account Details",
        "Log Out"
        );
  }
}
