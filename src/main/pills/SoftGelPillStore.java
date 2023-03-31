package pills;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class SoftGelPillStore {

    private GelCapFactory factory;
    private ArrayList<GelCap> currentOrder;
    private Scanner input;
    private PrintStream output;
    private String customerName;
    private int customerAge;
    private boolean isLoggedIn;

    public SoftGelPillStore(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    public SoftGelPillStore(PrintStream output) {
        this(new Scanner(System.in), output);
    }

    public SoftGelPillStore(Scanner input) {
        this(input, System.out);
    }

    public SoftGelPillStore() {
        this(new Scanner(System.in), System.out);
    }

    public void orderGelCap() {
        //no description for this??
    }

    public GelCap[] checkOut() {
        if(isLoggedIn == false || currentOrder == null) {
            System.out.print("You need to log in and order before you can checkout\n");
            return null;
        }
        else {
            System.out.print("Thanks for shopping!\nHere is your order\n");
        }

        //idk if this is right, doesn't feel like it
        currentOrder.toString();

        currentOrder.toArray();
        currentOrder.clear();

        //idk how to return the pills array
        return GelCap[];
    }

    public void order() {
        if(isLoggedIn == false) {
            System.out.print("You must log in before you can order.\n");
            return;
        }
        else {
            System.out.println("Hello " + customerName + ". What would you like to order?\n");
        }

        System.out.print("Options:\n 1) Dreamly\n 2) AcheAway\n 3) Cancel\n");
        int choice = input.nextInt();
        //TODO: check for 1, 2, or 3

        //use factory field to produce the type of pill and store in in currentOrder ArrayList
    }

    public void logIn() {
        System.out.println("What is your name?");
        String name = input.nextLine();
        System.out.println("What is your age?");
        int age = input.nextInt();
        //TODO: test for valid inputs

        logIn(name, age);
    }

    public void logIn(String name, int age) {
        customerName = name;
        customerAge = age;

        if (age < 18) {
            factory = ChildGelcapFactory;
        }
        else {
            factory = AdultGelCapFactory;
        }

        isLoggedIn = true;
        currentOrder = new ArrayList();
    }

    public boolean logOut() {
        if(isLoggedIn == false) {
            System.out.print("You are not logged in.");
            return false;
        }
        else if(currentOrder.size() > 0) {
            System.out.print("You have an order that you have not checked out. Are you sure you want to log out? (y/N)");
            String yn = input.nextLine();
            if(yn == "y") {
                continue;
            }
            else { //TODO: test for bad inputs
                return false;
            }
        }
        isLoggedIn = false;
        currentOrder = null;
        customerName = "";
        customerAge = -1;
        return true;
    }

    public void setOutput(PrintStream output) {
        this.output = output;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public PrintStream getOutput() {
        return output;
    }

    public Scanner getInput() {
        return input;
    }

}