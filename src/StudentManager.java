import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
  private List<Student> students = new ArrayList<>();
  private Scanner input = new Scanner(System.in);
  private int nextId = 1;

  public String inputUsername() {
    System.out.print("Enter username: ");
    return input.nextLine();
  }

  public String inputPassword() {
    System.out.print("Enter password: ");
    return input.nextLine();
  }

  public void register() {
    String username = inputUsername();
    String password = inputPassword();
    students.add(new Student(nextId, username, password));
    nextId++;
    System.out.println("Registration successful.");
  }

  public boolean login() {
    String username = inputUsername();
    String password = inputPassword();

    for (Student student : students) {
      if (student.getUsername().equals(username) && student.getPassword().equals(password)) {
        System.out.println("Login successful.");
        return false;
      }
    }
    System.out.println("Login failed. Username or password incorrect.");
    return true;
  }

  public void showMenu() {
    boolean isLoggedOut = true;
    while (isLoggedOut) {
      System.out.println("Log In or Register to Ceryx:");
      System.out.println("\n(1) Register");
      System.out.println("(2) Log In");
      System.out.println("(3) Exit");
      int choice = input.nextInt();
      input.nextLine();

      switch (choice) {
        case 1:
          register();
          break;
        case 2:
          isLoggedOut = login();
          break;
        case 3:
          return;
        default:
          System.out.println("Invalid option.");
      }
    }
  }
}

