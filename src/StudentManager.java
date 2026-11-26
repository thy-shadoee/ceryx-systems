import java.util.ArrayList;
import java.util.List;

/**
 * StudentManager
 */
public class StudentManager {
  private List<Student> students = new ArrayList<>();
  private int nextId = 1;
  private Student currentUser;

  public Student getCurrentUser() {
    return currentUser;
  }

  private Student findStudentByUsername(String username) {
    for (Student student: students) {
      if (student.getUsername().equals(username)) {
        return student;
      }
    }

    return null;
  }

  public boolean register(String username, String password) {
    username = username.trim();
    if (username == null || username.trim().isEmpty()) {
      System.out.println("Registration failed: Username must not be empty.");
      return false;
    }
    if (password == null || password.length() < 8) {
      System.out.println("Registration failed: Password must have at least eight (8) characters.");
      return false;
    }
    if (findStudentByUsername(username) != null) {
      System.out.println("Registration failed: This username already exists.");
      return false;
    }
    students.add(new Student(nextId, username, password));
    nextId++;
    return true;
  }

  public boolean login(String username, String password) {
    Student student = findStudentByUsername(username.trim());
    if (student != null && student.getPassword().equals(password)) {
      currentUser = student;
      return true;
    }

    return false;
  }

  public void logout() {
    this.currentUser = null;
  }
}

