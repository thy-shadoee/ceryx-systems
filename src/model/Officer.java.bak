import java.util.List;

public class Officer extends User {
  public Officer(int id, String username, String password) {
    super(id, username, password, Role.OFFICER);
  }

  @Override
  public List<MenuItem> getMenuItems(MenuActionFactory factory) {
    return List.of(
        factory.viewAnnouncements(),
        factory.manageAnnouncements(),
        factory.viewMembers(),
        factory.accountDetails(),
        factory.logout()
        );
  }
}
