public class Cheetos {
  private String type;
  private int quantity;

  public Cheetos(String type, int quantity) {
    this.type = type;
    if (quantity >= 0) {
      this.quantity = quantity;
    } else {
      this.quantity = 0;
    }
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void eat() {
    this.quantity--;
    System.out.println("That was yummy. Now I have " + this.quantity + " hot cheetos left!");
  }

  public boolean isEmpty() {
    return (this.quantity <= 0);
  }
}
