package ui;

import java.util.List;

import model.User;
import service.UserManager;

public class Dashboard {
  private final UserManager userManager;
  private final ConsoleInput input;

  public Dashboard(UserManager userManager, ConsoleInput input) {
    this.userManager = userManager;
    this.input = input;
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
    List<MenuItem> menuItems = factory.createMenuFor(currentUser);

    System.out.println();
    for (int i = 0; i < menuItems.size(); i++) {
      System.out.printf("(%d) %s%n", i+1, menuItems.get(i).label());
    }

    int choice = input.readInt();
    if (choice >= 1 && choice <= menuItems.size()) {
      menuItems.get(choice - 1).execute();
    } else {
      System.out.println("Invalid choice.");
    }
  }
}
