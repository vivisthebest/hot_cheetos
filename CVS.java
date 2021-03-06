public class CVS {
    private String location;
    private int numHotCheetos;
    
    public CVS(String location, int numHotCheetos) {
        if (location.equals("")) {
            this.location = "NOWHERE";
        } else {
            this.location = location;
        }
        if (numHotCheetos >= 0) {
            this.numHotCheetos = numHotCheetos;
        } else {
            this.numHotCheetos = 0;
        }
    }
    
    public Cheetos buyCheetos(String type, int quantity) {
        if (type.toLowerCase() == "hot") {
            if (this.numHotCheetos < quantity) {
                System.out.println("We don't have that many hot cheetos left.");
                System.out.println("Here are all the cheetos we have left.");
                quantity = this.numHotCheetos;
                this.numHotCheetos = 0;
                System.out.println("Buying " + quantity + " hot cheetos.");
                return new Cheetos("hot", quantity);
            } else {
                this.numHotCheetos -= quantity;
                System.out.println("Buying " + quantity + " hot cheetos.");
                return new Cheetos("hot", quantity);
            }
        } else {
            System.out.println("Don't be an idiot. You don't want " + type + " cheetos. You want hot cheetos.");
            return buyCheetos("hot", quantity);
        }
    }
    
    public void restockCheetos(int quantity) {
        this.numHotCheetos += quantity;
        System.out.println("The world can run again!");
    }
    
    public boolean isOutOfCheetos() {
        return (this.numHotCheetos == 0);
    }
    
    public String getLocation() {
        return this.location;
    }
    
    public int numCheetosLeft() {
        return this.numHotCheetos;
    }
}
