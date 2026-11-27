import java.util.InputMismatchException;
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
    User currentUser = userManager.getCurrentUser();
    if (currentUser == null) {
      return;
    }

    MenuActionFactory factory = new MenuActionFactory(currentUser, userManager);
    List<MenuItem> menuItems = currentUser.getMenuItems(factory);

    System.out.println();
    for (int i = 0; i < menuItems.size(); i++) {
      System.out.printf("(%d) %s%n", i+1, menuItems.get(i).label());
    }

    try {
      int choice = input.nextInt();
      input.nextLine();
      if (choice >= 1 && choice <= menuItems.size()) {
        menuItems.get(choice - 1).execute();
      } else {
        System.out.println("Invalid choice.");
      }
    } catch (InputMismatchException e) {
      System.out.println("Invalid input: " + e.getMessage());
      input.nextLine();
    }
  }
}
