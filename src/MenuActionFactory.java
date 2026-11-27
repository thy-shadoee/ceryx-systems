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
}
