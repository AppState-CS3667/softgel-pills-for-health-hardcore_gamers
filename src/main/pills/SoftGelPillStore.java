package pills;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
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

    public GelCap[] checkOut() {
        if (isLoggedIn == false || currentOrder == null) {
            System.out.print("You need to log in and order before you can checkout\n");
            return null;
        }
        else {
            System.out.print("Thanks for shopping!\nHere is your order\n");
        }

        currentOrder.toString();

        Object[] orderarr = currentOrder.toArray();
        currentOrder.clear();

        return (GelCap[]) orderarr;
    }

    public void order() {
        if (isLoggedIn == false) {
            System.out.print("You must log in before you can order.\n");
            return;
        }
        else {
            System.out.println("Hello " + customerName + ". What would you like to order?\n");
        }

        boolean loop = true;
        int choice;
        while (loop) {
            try {
                System.out.print("Options:\n 1) Dreamly\n 2) AcheAway\n 3) Cancel\n");
                choice = input.nextInt();

                if (choice == 1) {
                    //use the factory field to produce the type of pill 
                    //selected and store it in the currentOrder ArrayList.
                    currentOrder.add(factory.produceDreamly());
                    loop = false;
                }
                else if (choice == 2) {
                    currentOrder.add(factory.produceAcheAway());
                    loop = false;
                }
                else if (choice == 3) {
                    loop = false;
                }
            }
            catch (InputMismatchException e) {
                System.out.print("Please enter a 1, 2, or 3\n");
                input.nextLine();
            }

        }
    }

    public void logIn() {
        System.out.println("What is your name?");
        String name = input.nextLine();
        
        boolean loop = true;
        int age = -1;
        while (loop) {
            try {
                System.out.println("What is your age?");
                age = input.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.print("Please enter a valid age.");
                input.nextLine();
            }
        }

        logIn(name, age);
    }

    public void logIn(String name, int age) {
        customerName = name;
        customerAge = age;

        if (customerAge < 18) {
            factory = new ChildGelCapFactory();
        }
        else {
            factory = new AdultGelCapFactory();
        }

        isLoggedIn = true;
        currentOrder = new ArrayList<GelCap>();
    }

    public boolean logOut() {
        if (isLoggedIn == false) {
            System.out.print("You are not logged in.");
            return false;
        }
        else if (currentOrder.size() > 0) {
            boolean loop = true;
            String yn;
            while (loop) {
                try {
                    System.out.print("You have an order that you have not checked out. Are you sure you want to log out? (y/N)");
                    yn = input.nextLine();
    
                    if (yn == "y") {
                        continue;
                    }
                    else {
                        return false;
                    }
                }
                catch (InputMismatchException e) {
                    System.out.print("Please enter a valid character.");
                    input.nextLine();
                }
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
