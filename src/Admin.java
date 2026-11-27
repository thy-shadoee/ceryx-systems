import java.util.List;

public class Admin extends User {
  public Admin(int id, String username, String password) {
    super(id, username, password, Role.ADMIN);
  }

  @Override
  public List<MenuItem> getMenuItems(MenuActionFactory factory) {
    return List.of(
        factory.viewAnnouncements(),
        factory.manageAnnouncements(),
        factory.manageUsers(),
        factory.viewMembers(),
        factory.accountDetails(),
        factory.logout()
        );
  }
}
