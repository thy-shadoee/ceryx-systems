public class CredentialsValidator {
  public String cleanUsername(String username) {
    if (username == null) {
      return "";
    }

    return username.trim();
  }

  public boolean isValidUsername(String username) {
    return username != null && !username.isEmpty();
  }

  public boolean isValidPassword(String password) {
    return password != null && password.length() >= 8;
  }
}
