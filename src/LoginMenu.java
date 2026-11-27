import java.util.Scanner;

/**
 * LoginMenu
 */
public class LoginMenu {
  private UserManager userManager;
  private Scanner input = new Scanner(System.in);

  public LoginMenu(UserManager userManager) {
    this.userManager = userManager;
  }

  private void registerUser() {
    System.out.print("Enter username: ");
    String username = input.nextLine();
    System.out.print("Enter password: ");
    String password = input.nextLine();
    if (userManager.register(username, password)) {
      userManager.login(username, password);
      System.out.println("Registration successful. You are now logged in.");
    }
  }

  private void loginUser() {
    System.out.print("Enter username: ");
    String username = input.nextLine();
    System.out.print("Enter password: ");
    String password = input.nextLine();
    if (!userManager.login(username, password)) {
      System.out.println("Login failed. Username or password are incorrect.");
      return;
    }
    System.out.println("Login successful.");
  }

  public boolean display() {
    while (userManager.getCurrentUser() == null) {
      System.out.println("Log In or Register to Ceryx:");
      System.out.println("\n(1) Register");
      System.out.println("(2) Log In");
      System.out.println("(3) Exit");

      String choice = input.nextLine();

      switch (choice) {
        case "1":
          registerUser();
          break;
        case "2":
          loginUser();
          break;
        case "3":
          return false;
        default:
          System.out.println("Invalid option.");
      }
    }

    return true;
  }
 
}
