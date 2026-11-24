import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
  private List<Student> students = new ArrayList<>();
  private Scanner input = new Scanner(System.in);
  private int nextId = 1;
  private boolean isLoggedIn = false;
  private Student currentUser;

  private boolean validatePassword(String pw, int length) {
    if (pw.length() >= length) {
      return true;
    } else {
      return false;
    }
  }

  private String inputUsername() {
    System.out.print("Enter username: ");
    return input.nextLine();
  }

  private String inputPassword(boolean isRegistered) {
    while(true) {
      System.out.print("Enter password: ");
      String password = input.nextLine();
      if (isRegistered == false) {
        if (validatePassword(password, 8) == true) {
          return password;
        } else {
          System.out.println("Your password must be at least eight (8) characters.");
        }
      } else {
        return password;
      }
    }
  }

  public Student getCurrentUser() {
    return currentUser;
  }

  public boolean getLoginStatus() {
    return isLoggedIn;
  }

  public void register() {
    String username = inputUsername();
    String password = inputPassword(false);
    students.add(new Student(nextId, username, password));
    nextId++;
    System.out.println("Registration successful.");
  }

  public boolean login() {
    String username = inputUsername();
    String password = inputPassword(true);

    for (Student student : students) {
      if (student.getUsername().equals(username) && student.getPassword().equals(password)) {
        System.out.println("Login successful.");
        this.currentUser = student;
        return true;
      }
    }
    System.out.println("Login failed. Username or password incorrect.");
    return false;
  }

  public void logout() {
    this.currentUser = null;
    this.isLoggedIn = false;
  }

  public boolean showMenu() {
    while (!isLoggedIn) {
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
          this.isLoggedIn = login();
          break;
        case 3:
          return false;
        default:
          System.out.println("Invalid option.");
      }
    }

    return true;
  }
}

