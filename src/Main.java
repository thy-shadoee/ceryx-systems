public class Main {
  public static void main(String[] args) {
    StudentManager manager = new StudentManager();
    Dashboard db = new Dashboard(manager);
    while (manager.showMenu()) {
      db.greetUser();
      while (manager.getCurrentUser() != null) {
        db.showMenu();
      }
    }
  }
}
