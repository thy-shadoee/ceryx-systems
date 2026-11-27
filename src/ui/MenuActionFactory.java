package ui;

import java.util.ArrayList;
import java.util.List;

import model.Role;
import model.User;
import service.UserManager;

public class MenuActionFactory {
  private final User currentUser;
  private final UserManager userManager;

  public MenuActionFactory(User currentUser, UserManager userManager) {
    this.currentUser = currentUser;
    this.userManager = userManager;
  }

  public MenuItem viewAnnouncements() {
    return new ViewAnnouncementsAction();
  }

  public MenuItem manageAnnouncements() {
    return new ManageAnnouncementsAction();
  }

  public MenuItem manageUsers() {
    return new ManageUsersAction();
  }
  
  public MenuItem viewMembers() {
    return new ViewMembersAction();
  }

  public MenuItem accountDetails() {
    return new AccountDetailsAction(currentUser);
  }

  public MenuItem logout() {
    return new LogoutAction(userManager::logout);
  }

  public List<MenuItem> createMenuFor(User user) {
    List<MenuItem> items = new ArrayList<>();

    items.add(viewAnnouncements());

    if (user.getRole().hasAtLeast(Role.OFFICER)) {
      items.add(manageAnnouncements());
      items.add(viewMembers());
    }

    if (user.getRole().hasAtLeast(Role.ADMIN)) {
      items.add(manageUsers());
    }

    items.add(accountDetails());
    items.add(logout());

    return items;
  }
}
