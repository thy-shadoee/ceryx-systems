import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dashboard {
  private final UserManager userManager;
  private Scanner input = new Scanner(System.in);

  public Dashboard(UserManager userManager) {
    this.userManager = userManager;
  }

  public void greetUser() {
    User currentUser = userManager.getCurrentUser();
    if (currentUser == null) {
      return;
    }
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
        case "Account Details":
          System.out.println("Not Implemented Yet.");
          break;
        case "Log Out":
          userManager.logout();
          return;
        default:
          System.out.println("Invalid choice.");
      }
    } else {
      System.out.println("Invalid choice.");
    }
  }
}
