package ui;

public class LogoutAction implements MenuItem {
  private final Runnable logout;

  public LogoutAction(Runnable logout) {
    this.logout = logout;
  }

  @Override
  public String label() {
    return "Log Out";
  }

  @Override
  public void execute() {
    logout.run();
  }
}
