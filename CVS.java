public class CVS {
  private String location;
  private int numHotCheetos;

  public CVS(String location, int numHotCheetos) {
    this.location = location;
    this.numHotCheetos = numHotCheetos;
  }

  public Cheetos buyCheetos(String type, int quantity) {
    if (type.toLowerCase() == "hot") {
      if (this.numHotCheetos < quantity) {
        System.out.println("We don't have that many hot cheetos left.");
        System.out.println("Here area all the cheetos we have left.");
        quantity = this.numHotCheetos;
        this.numHotCheetos = 0;
        System.out.println("Buying " + quantity + " hot cheetos.")
        return new Cheetos("hot", quantity);
      } else {
        this.numHotCheetos -= quantity;
        System.out.println("Buying " + quantity + " hot cheetos.")
        return new Cheetos("hot", quantity);
      }
    } else {
      System.out.println("Don't be an idiot. You want hot cheetos.");
      return buyCheetos("hot", quantity);
    }
  }

  public void restockCheetos(int quantity) {
    this.numHotCheetos += quantity;
    System.out.println("The world can run again!");
  }
}
