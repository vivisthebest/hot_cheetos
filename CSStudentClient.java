import java.util.Scanner;

public class CSStudentClient {
    public static final int MAX_VALUE = 2147483647; // because you want the moost possible cheetos
    
    public static void main(String []args) {
        Scanner input = new Scanner(System.in); 
        boolean exit = false;
        String name = "stranger";
        String location = "";
        Cheetos stash = new Cheetos("hot", 0);
        CVS myCVS = null;
        
        while (!exit) {
            int choice = -1;
            printMenu(name, stash); // show the user the menu
            while (choice == -1) {
                choice = getValidInt(input, 7); // get the user to give a valid choice from the menu
            }
            switch (choice) { // do what the user told you to
                case 1: { // the user wants to change their name
                    System.out.println("What is your name?");
                    name = "";
                    while (name.equals("")) {
                        name = getValidWord(input);
                    }
                    break;
                }
                case 2: { // the user is setting up their first CVS!
                    if (myCVS == null) {
                        System.out.println("Where is your CVS located?");
                        location = "";
                        while (location.equals("")) {
                            location = getValidWord(input);
                        }
                        myCVS = new CVS(location, MAX_VALUE); // stock CVS with ALL the cheetos
                        System.out.println("Your new local CVS at " + location + " is now fully stocked.");
                    } else {
                        System.out.println("You have a local CVS at " + myCVS.getLocation() + "!");
                    }
                    break;
                }
                case 3: { // the user is sick of their CVS and wants a different one.
                    if (myCVS == null) {
                        System.out.println("You can't change your CVS if you don't already have a CVS!");
                        break;
                    }
                    System.out.println("Where is your new CVS located?");
                    location = "";
                    while (location.equals("")) {
                        location = getValidWord(input);
                    }
                    myCVS = new CVS(location, MAX_VALUE); // stock the new CVS with ALLL the cheetos
                    System.out.println("Your new local CVS at " + location + " is now fully stocked.");
                    break;
                }
                case 4: { // the user has bought alll of the cheetos at their CVS and wants more
                    if (myCVS == null) {
                        System.out.println("You can't restock cheetos until you set up a CVS!");
                        break;
                    }
                    myCVS = new CVS(location, MAX_VALUE);
                    System.out.println("Your CVS at " + location + " has been restocked!");
                    break;
                }
                case 5: { // the user wants to buy some cheetos
                    if (myCVS == null) {
                        System.out.println("You can't buy cheetos until you set up a CVS!");
                        break;
                    } else if (stash.getQuantity() == MAX_VALUE) {
                        System.out.println("Your stash is overflowing, please eat some cheetos before you buy more.");
                        break;
                    } else if (myCVS.isOutOfCheetos()) {
                        System.out.println("CVS is out of cheetos! Please restock.");
                        break;
                    }
                    System.out.println("What type of cheetos would you like?");
                    String type = "";
                    while (type.equals("")) {
                        type = getValidWord(input);
                    }
                    int max = min(myCVS.numCheetosLeft(), MAX_VALUE-stash.getQuantity()); // we don't want to go over MAX_VAL because errors!
                    System.out.println("How many " + type + " cheetos would you like to buy? (max possible: " + max + ")");
                    int quantity = -1;
                    while (quantity == -1) { 
                        quantity = getValidInt(input, max);
                    }
                    Cheetos newcheetos = myCVS.buyCheetos(type, quantity);
                    stash = new Cheetos("hot", newcheetos.getQuantity() + stash.getQuantity()); // add the new cheetos to the stash
                    System.out.println("Current cheetos in stash: " + stash.getQuantity());
                    break;
                }
                case 6: { // the user wants to eat some cheetos
                    if (stash.getQuantity() == 0) {
                        System.out.println("You don't have any cheetos to eat!");
                        break;
                    }
                    System.out.println("How many cheetos would you like to eat?");
                    int quantity = -1;
                    while (quantity == -1) {
                        quantity = getValidInt(input, stash.getQuantity());
                    }
                    for (int i = 0; i < quantity; i++) {
                        stash.eat();
                    }
                    System.out.println("Ate " + quantity + " cheetos total.");
                    break;
                }
                case 7: { // the user is done with this nonsense
                    exit = true;
                    System.out.println("Goodbye! Your cheetos will not be saved.");
                    break;
                }
            }
            
        }
    }
    
    
    // nice little method that prints out the main menu
    public static void printMenu(String name, Cheetos stash) {
        System.out.println("Hello, " + name + "!");
        System.out.println("What would you like to do today? (You have " + stash.getQuantity() + " cheetos.)");
        System.out.println("Choose an option from the list: ");
        System.out.println("1: Change my name\n2: Set up my local CVS\n3: Change my local CVS\n4: Restock CVS");
        System.out.println("5: Buy hot cheetos\n6: Eat hot cheetos\n7: Exit");
    }
    
    // returns a positive (nonzero) int that is less than max or -1 if the user is being silly
    public static int getValidInt(Scanner input, int max) {
        int i = -1;
        if (input.hasNextInt()) {
            i = input.nextInt();
            input.nextLine();
            if (i < 1 || i > max) {
                System.out.println("You can't do that!");
                i = -1;
            }
        } else {
            String s = input.nextLine();
            System.out.println(s + " is not a number!");
        }
        return i;
    }
    
    // returns a String or "" if the user is being silly
    public static String getValidWord(Scanner input) {
        String s = "";
        if (input.hasNextLine()) {
            s = input.nextLine();
        }
        if (s.equals("")) {
            System.out.println("You didn't enter anything!");
        }
        return s;
    }

    public static int min(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }
    
}
