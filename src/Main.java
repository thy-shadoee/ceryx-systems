public class Main {
  public static void main(String[] args) {
    StudentManager studentManager = new StudentManager();
    LoginMenu loginMenu = new LoginMenu(studentManager);
    Dashboard db = new Dashboard(studentManager);
    while (loginMenu.display()) {
      db.greetUser();
      while (studentManager.getCurrentUser() != null) {
        db.showMenu();
      }
    }
  }
}
