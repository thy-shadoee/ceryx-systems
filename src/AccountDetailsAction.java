public class AccountDetailsAction implements MenuItem {
  public final User user;

  public AccountDetailsAction(User user) {
    this.user = user;
  }

  @Override
  public String label() {
    return "Account Details";
  }

  @Override
  public void execute() {
    System.out.println("Viewing account details not implemented yet.");
  }
}
