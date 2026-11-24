import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dashboard {
  private final StudentManager manager;
  private Scanner input = new Scanner(System.in);

  public Dashboard(StudentManager manager) {
    this.manager = manager;
  }

  public void greetUser() {
    Student currentUser = manager.getCurrentUser();
    System.out.printf("\nWelcome, %s!\n", currentUser.getUsername());
  }

  public void showMenu() {
    List<String> menuItems = new ArrayList<>();

    // TODO: Add menu items based on permission level.
    menuItems.add("View Announcements");
    menuItems.add("Account Details");
    menuItems.add("Log Out");

    System.out.println();
    for (int i = 0; i < menuItems.size(); i++) {
      int idx = i + 1;
      System.out.printf("(%d) %s\n", idx, menuItems.get(i));
    }

    int choice = input.nextInt();
    input.nextLine();
    if (choice >= 1 && choice <= menuItems.size()) {
      String selectedMenuItem = menuItems.get(choice - 1);

      switch (selectedMenuItem) {
        case "View Announcements":
          // TODO: Implement announcement menu.
          break;
        case "Account Details":
          // TODO: Implement account details.
          break;
        case "Log Out":
          manager.logout();
          return;
        default:
          System.out.println("Invalid choice.");
      }
    } else {
      System.out.println("Invalid choice.");
    }
  }
}
