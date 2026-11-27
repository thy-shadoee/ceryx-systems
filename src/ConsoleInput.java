import java.util.Scanner;

public class ConsoleInput {
  private final Scanner input = new Scanner(System.in);

  public String readLine() {
    return input.nextLine();
  }

  public int readInt() {
    while (!input.hasNextInt()) {
      System.out.println("Invalid input. Please enter a number.");
      input.nextLine();
    }

    int value = input.nextInt();
    input.nextLine();
    return value;
  }
}
