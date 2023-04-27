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
                System.out.println("=================================");
                System.out.println("Choose from the following Menu:");
                System.out.println(" 1) Order");
                System.out.println(" 2) Checkout");
                System.out.println(" 3) Logout");
                System.out.println("=================================");
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
                    GelCap[] order = store.checkOut();
                    if (order != null) {
                        orders.add(order);
                    }
                    store.logOut();
                    break loop;
                case 3:
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
            return choice == 1 || choice == 2 || choice == 3;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
