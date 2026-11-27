public class Main {
  public static void main(String[] args) {
    UserManager userManager = new UserManager();
    ConsoleInput input = new ConsoleInput();
    LoginMenu loginMenu = new LoginMenu(userManager, input);
    Dashboard db = new Dashboard(userManager, input);
    while (loginMenu.display()) {
      db.greetUser();
      while (userManager.getCurrentUser() != null) {
        db.showMenu();
      }
    }
  }
}
