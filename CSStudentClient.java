import java.util.Scanner;

public class CSStudentClient {
  public static final int MAX_VALUE;

  public static void main(String []args) {
    Scanner input = new Scanner(System.in);
    String location;

    System.out.print("Welcome! Where is your closest CVS?\nEnter location and press Enter");
    if (input.hasNextLine()) location = input.nextLine();
    CVS home = new CVS(location, MAX_VALUE);

    System.out.print("How many bags of cheetos do you want?");
    while (input.hasNextInt()) {
      int quantity = input.nextInt();
      System.out.print("What type of cheetos do you want?");
      input.nextLine();
      if (input.hasNext()) {
        Cheetos cheetosStash = home.buyCheetos(input.next(), quantity);

        while (cheetosStash.getQuantity() > 0) {
          cheetosStash.eat();
        }
      }

      System.out.print("How many bags of cheetos do you want?");
    }
  }
}
