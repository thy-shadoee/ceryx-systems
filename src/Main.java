public class Main {
  public static void main(String[] args) {
    UserManager userManager = new UserManager();
    LoginMenu loginMenu = new LoginMenu(userManager);
    Dashboard db = new Dashboard(userManager);
    while (loginMenu.display()) {
      db.greetUser();
      while (userManager.getCurrentUser() != null) {
        db.showMenu();
      }
    }
  }
}
