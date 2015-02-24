public class Cheetos {
  private String type;
  private int quantity;

  public Cheetos(String type, int quantity) {
    this.type = type;
    this.quantity = quantity;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void eat() {
    this.quantity--;
    System.out.println("That was yummy. Now I have " + this.quantity + " hot cheetos left!")
  }

  public boolean isEmpty() {
    return (this.quantity <= 0);
  }
}
