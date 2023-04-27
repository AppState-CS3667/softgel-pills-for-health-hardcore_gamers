package client;
import java.util.ArrayList;
import java.util.Scanner;

import pills.GelCap;
import pills.SoftGelPillStore;

/**
 * Demo class that provides an interface to use the SoftGelPillStore.
 * 
 * @author Willow Sapphire
 * @version 02/24/2023
 */
public class Demo {
    /**
     * A simple interface to interact with the SoftGelPillStore.
     * 
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SoftGelPillStore store = new SoftGelPillStore(input, System.out);
        ArrayList<GelCap[]> orders = new ArrayList<>();
        System.out.println("Log In: ");
        store.logIn();
        boolean exit = false;
        loop : while (!exit) {
            String choice = "";
           // while (!validSelection(choice)) {
<<<<<<< HEAD
                System.out.println("=================================");
                System.out.println("Choose from the following Menu:");
                System.out.println(" 1) Order");
                System.out.println(" 2) Checkout");
                System.out.println(" 3) Logout");
                System.out.println("=================================");
=======
                System.out.println("=========================");
                System.out.println("Choose from the following menu");
                System.out.println("=========================");
                System.out.println("1) Order");
                System.out.println("2) Manage Order");
                System.out.println("3) Checkout");
                System.out.println("4) Logout");
                System.out.println("=========================");
>>>>>>> 2511d6c (Working on Manage Order)
                input.nextLine();
                choice = input.nextLine();
                if (!validSelection(choice)) {
                    System.out.println("Please select an option from the menu");
                }
            //}
            switch (Integer.parseInt(choice)) {
                case 1:
                    store.order();
                    break;
                case 2:
                    System.out.println("Your current order is :");
                    store.printCurrentOrder();
                    System.out.println("Would you like to remove an item"
                    + " from your order? Y or N");
                    choice = input.nextLine();
                    if (choice.equals("Y".toLowerCase())) {
                        System.out.println("Which item would you like to remove?");
                        choice = input.nextLine();
                        int rem;
                        try {
                            rem = Integer.parseInt(choice);
                        }
                        catch (NumberFormatException e) {
                            System.out.println("That is not a valid number.");
                        }
                        store.removePill(rem);
                        break;
                    }
                    else {
                        break;
                    }
                case 3: 
                    GelCap[] order = store.checkOut();
                    if (order != null) {
                        orders.add(order);
                    }
                    store.logOut();
                    break loop;
                case 4:
                    exit = store.logOut();
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
     * @param selection the string entered by the user
     * @return true if the selection was valid, false otherwise
     */
    private static boolean validSelection(String selection) {
        try {
            int choice = Integer.parseInt(selection);
            return choice == 1 || choice == 2 || choice == 3 || choice == 4;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
