public class Student {
  private int id;
  private String username;
  private String password;

  // Constructor
  protected Student(int id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }

  // Getters
  public int getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  // Setters
  public void setPassword(String pw) {
    this.password = pw;
  }
}

