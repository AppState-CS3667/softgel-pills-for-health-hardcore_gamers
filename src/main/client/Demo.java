package client;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import pills.GelCap;
import pills.SoftGelPillStore;

/*
 * Demo class that provides an interface to use the SoftGelPillStore.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class Demo {

    public static Scanner input = new Scanner(System.in);
    public static SoftGelPillStore store = 
                new SoftGelPillStore(input, System.out);

    /**
     * A simple interface to interact with the SoftGelPillStore.
     * 
     * @param args unused
     */
    public static void main(String[] args) {
        ArrayList<GelCap[]> orders = new ArrayList<>();
        System.out.println("Log In: ");
        store.logIn();
        boolean exit = false;
        loop: while (!exit) {
            String choice = "";
            System.out.println("===========================================");
            System.out.println("Choose from the following menu");
            System.out.println("===========================================");
            System.out.println(" 1) Order");
            System.out.println(" 2) Manage Order");
            System.out.println(" 3) Checkout");
            System.out.println(" 4) Inspect Order");
            System.out.println(" 5) Logout");
            System.out.println("===========================================");

            choice = input.nextLine();
            if (!validSelection(choice)) {
                System.out.println("Please select an option from the menu");
            }
            
            switch (Integer.parseInt(choice)) {
                case 1:
                    store.order();
                    break;
                case 2:
                    manageOrder();
                    //input.next();
                    break;
                case 3: 
                    GelCap[] order = store.checkOut();
                    if (order != null) {
                        orders.add(order);
                    }
                    store.logOut();
                    break loop;
                case 4:
                    if (store.getOrderSize() < 1) {
                        System.out.println("There must be at least" 
                                + " one item in your order to inspect it.");
                    }
                    else {
                        inspectorMenu();
                    }
                    break;
                case 5:
                    exit = store.logOut();
                    break;
                default:
                    break;
            }
        }
        System.out.println("Here is what you ordered:");
        int orderNum = 0;
        for (GelCap[] order : orders) {
            System.out.printf("Order Number %d\n", ++orderNum);
            for (GelCap g : order) {
                System.out.printf("\t%s\n", g);
            }
            System.out.println();
        }
        input.close();
    }

    /**
     * Helper method that checks if use input is a 1, 2, or 3.
     * 
     * @param selection the string entered by the user
     * @return true if the selection was valid, false otherwise
     */
    private static boolean validSelection(String selection) {
        try {
            int choice = Integer.parseInt(selection);
            return choice == 1 || choice == 2 || choice == 3 
                    || choice == 4 || choice == 5;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

     /*
     * Helper method to print a menu for inspector checks
     */
    private static void inspectorMenu() {
        boolean loop = true;
        int choice;
        double fi = store.checkFailRate();
        while (loop) {
            try {
                System.out.println("=================================");
                System.out.print("Options:\n 1) " 
                    + "Check Fail Rate\n 2) Check if Fail Rate too Big\n" 
                    + " 3) Check if Consistent Order\n");
                System.out.println("=================================");
                choice = input.nextInt();

                
                if (choice == 1) {
                    double failRate = store.checkFailRate();
                    System.out.println("The current fail rate on"
                                        + " your order is: " + failRate);
                    input.nextLine();
                    loop = false;
                }
                else if (choice == 2) {
                    boolean tooBig = store.tooBigFailRate(fi);
                    if (!tooBig) {
                        System.out.println("The fail rate on your order "
                                            + "is okay.");
                    }
                    else {
                        System.out.println("The fail rate on your order "
                                            + "is too large.");
                    }
                    loop = false;
                    input.nextLine();
                }
                else if (choice == 3) {
                    boolean consistent = store.consistentOrder();
                    if (!consistent) {
                        System.out.println("Your order is not consistent.");
                    }
                    else {
                        System.out.println("Your order is consistent.");
                    }
                    loop = false;
                    input.nextLine();
                }
            }
            catch (InputMismatchException e) {
                System.out.print("Please enter a 1, 2, or 3\n");
                input.nextLine();
            }
        }
    }

    /*
     * Helper method that allows the client to remove from their order.
     */
    private static void manageOrder() {
        String choice;
        boolean loop = true;
        while (loop) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Your current order is:");
            store.printCurrentOrder();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Would you like to remove an item"
                + " from your order? Y or N");
            choice = input.nextLine();
            if (choice.toLowerCase().equals("y")) {
                store.printCurrentOrder();
                System.out.println("Note: The Order List starts with pill 1.");
                System.out.println("Which item would you like to remove?");
                int rem = -1;
                boolean check = true;
                while (check) {
                    choice = input.nextLine();
                    try {
                        rem = Integer.parseInt(choice);
                        check = false;
                    }
                    catch (NumberFormatException e) {
                        System.out.println("That is not a valid number.");
                    }
                }
                if (rem < store.getOrderSize()) {
                    rem -= 1;
                    store.removePill(rem);
                    loop = false;
                }
                else {
                    System.out.println("That is not a valid pill.");
                    System.out.println("Rem is: " + rem);
                }
                
            }
            else {
                loop = false;
            }
        }
    }
}
