import java.util.List;

public class Admin extends User {
  public Admin(int id, String username, String password) {
    super(id, username, password, Role.ADMIN);
  }

  @Override
  public List<String> getMenuItems() {
    return List.of(
        "View Announcements",
        "Manage Announcements",
        "Manager Members",
        "Account Details",
        "Log Out"
        );
  }
}
