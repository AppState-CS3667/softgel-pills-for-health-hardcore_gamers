package pills;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * SoftGelPillStore class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class SoftGelPillStore  {

    private GelCapFactory factory;
    private ArrayList<GelCap> currentOrder;
    private Scanner input;
    private PrintStream output;
    private String customerName;
    private int customerAge;
    private boolean isLoggedIn;

    /*
     * 2 arg constructor to get Scanner input and 
     * Printstream output.
     * 
     * @param input Scanner input
     * @param output Printstream output
     */
    public SoftGelPillStore(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    /*
     * 1 arg constructor to set output from param
     * and passes in new scanner for input.
     * 
     * @param output Printstream output
     */
    public SoftGelPillStore(PrintStream output) {
        this(new Scanner(System.in), output);
    }

    /*
     * 1 arg constructor to set input from param
     * and passes in new Printstream for output.
     * 
     * @param input Scanner input
     */
    public SoftGelPillStore(Scanner input) {
        this(input, System.out);
    }

    /*
     * no arg constructor to pass to 2-arg constructor.
     * passes in new Scanner and System.out.
     */
    public SoftGelPillStore() {
        this(new Scanner(System.in), System.out);
    }

    /*
     * checks to make sure logged in. 
     * checks to make sure order is consistent.
     * checks to make sure fail rate is not too big.
     * if logged in print the order, converts to array
     * and returns the array.
     * 
     * @return null if error
     * @return gcOrderArr array of gel caps in the current order.
     */
    public GelCap[] checkOut() {
        //call method to walk through failure inspector
        double fi = checkFailRate();

        if (isLoggedIn == false || currentOrder == null) {
            System.out.print("You need to log in and" 
                + "order before you can checkout\n");
            return null;
        }
        else if (consistentOrder() == false) {
            System.out.print("Your order is not consistent\n");
            return null;
        }
        else if (tooBigFailRate(fi)) {
            System.out.print("The fail rate on your order is too large\n");
            return null;
        }
        else {
            System.out.print("Thanks for shopping!\nHere is your order\n");
        }

        System.out.println(currentOrder.toString());

        Object[] orderarr = currentOrder.toArray();
        GelCap[] gcOrderArr = new GelCap[orderarr.length];
        System.arraycopy(orderarr, 0, gcOrderArr, 0, gcOrderArr.length);
        currentOrder.clear();

        return gcOrderArr;
    }

    /*
     * checks to make sure logged in. if logged in
     * prints menu and checks to make sure user input
     * is valid.
     */
    public void order() {
        if (isLoggedIn == false) {
            System.out.print("You must log in before you can order.\n");
            return;
        }
        else {
            System.out.println("===========================================");
            System.out.print("Hello " + customerName 
                +  "! What would you like to order?\n");
        }

        boolean loop = true;
        int choice;
        while (loop) {
            try {
                System.out.println("====================="
                                    + "======================");
                System.out.print("Options:\n 1) " 
                    + "Dreamly\n 2) AcheAway\n 3) Cancel\n");
                System.out.println("====================="
                                    + "======================");
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
                input.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.print("ERROR: Invalid Input!\n"
                                + "Please enter a 1, 2, or 3\n");
                input.nextLine();
            }

        }
    }

    /*
     * asks user for name and age.
     * once gets valid age passes to 2 arg log-in.
     */
    public void logIn() {
        System.out.print(" What is your name? ");
        String name = input.nextLine();        
        boolean loop = true;
        int age = -1;
        while (loop) {
            try {
                System.out.print(" What is your age? ");
                age = input.nextInt();
                System.out.println();
                input.nextLine();
                loop = false;
            }
            catch (InputMismatchException e) {
                System.out.println("ERROR: Invalid Age!\n"
                                    + "Please enter a valid age.");
                input.nextLine();
            }
        }

        logIn(name, age);
    }

    /*
     * checks to see if age is less than 18.
     * if less than 18 sets factory to child
     * else sets factory to adult.
     * sets logged in to true.
     * 
     * @param name - name of the user.
     * @param age - the age of the user.
     */
    public void logIn(String name, int age) {
        customerName = name;
        customerAge = age;
        final int ADULTAGE = 18;
        if (customerAge < ADULTAGE) {
            factory = ChildGelCapFactory.getInstance();
        }
        else {
            factory = AdultGelCapFactory.getInstance();
        }

        isLoggedIn = true;
        currentOrder = new ArrayList<GelCap>();
    }

    /*
     * checks to see if logged in first.
     * if logged in and order still is not checked out
     * asks for override. 
     * clears order and resets all variables.
     * 
     * @return false if not logged in, or in 
     * process of ordering
     * @return true if successfully logged out
     */
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
                    System.out.println("You have an order that you have not " 
                        + "checked out. Are you sure you"
                        + " want to log out? (y/N)");
                    yn = input.nextLine();
    
                    if (yn.toLowerCase().equals("y")) {
                        loop = false;
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

    /*
     * sets output.
     * 
     * @param output PrintStream output
     */
    public void setOutput(PrintStream output) {
        this.output = output;
    }

    /*
     * sets input.
     * 
     * @param input Scanner input
     */
    public void setInput(Scanner input) {
        this.input = input;
    }

    /*
     * gets output.
     * 
     * @return output PrintStream output
     */
    public PrintStream getOutput() {
        return output;
    }

    /*
     * gets input.
     * 
     * @return input Scanner input
     */
    public Scanner getInput() {
        return input;
    }

    /*
     * uses a strength inspector to calculate order strengths.
     * 
     * @return Dreamly order strength.
     */
    public double getDreamlyStrength(int orderNum) {
        //use a strength inspector to calc
        StrengthInspector si = new StrengthInspector();
        si.reset();
        for (int i = 0; i < currentOrder.size(); i++) {
            GelCap pill = currentOrder.get(i);
            //call accept in double dispatch to get the GelCap type
            pill.accept(si);
        }
        return si.getDreamlyStrength();
    }

    /*
     * uses a strength inspector to calculate order strengths.
     * 
     * @return AcheAway order strength.
     */
    public double getAcheAwayStrength(int oderNum) {
        //use a strength inspector to calc
        StrengthInspector si = new StrengthInspector();
        si.reset();
        for (int i = 0; i < currentOrder.size(); i++) {
            GelCap pill = currentOrder.get(i);
            //call accept in double dispatch to get the GelCap type
            pill.accept(si);
        }
        return si.getAcheAwayStrength();
    }

    /*
     * prints the current order from the ArrayList.
     */
    public void printCurrentOrder() {
        //System.out.println();
        System.out.println(currentOrder.toString());
    }

    /*
     * checks the fail rate. 10 is the average. 15 is too
     * large.
     * 
     * @param failRate - the failRate.
     * @return boolean true if order fail rate too large.
     * @return boolean false if order fail rate ok.
     */
    public boolean tooBigFailRate(double failRate) {
        //changed to public so that the client can monitor and 
        //change their order as needed.
        if (failRate >= 15) {
            return true;
        }
        return false;
    }

    /*
     * uses a FailureInspector to calculate and return the 
     * current fail rate.
     * 
     * @return fail rate.
     */
    public double checkFailRate() {
        //changed to public so that the client can monitor and 
        //change their order as needed.
        FailureInspector fi = new FailureInspector();
        fi.reset();
        if (currentOrder == null) {
            return 0;
        }
        for (int i = 0; i < currentOrder.size(); i++) {
            GelCap pill = currentOrder.get(i);
            //call accept in double dispatch to get the GelCap type
            pill.accept(fi);
        }
        return fi.getFailRate();
    }

    /*
     * uses a ConsistencyInspector to check if the current 
     * order is consistent.
     * 
     * @return true if consistent.
     * @return false if not consistent.
     */
    public boolean consistentOrder() {
        //changed to public so that the client can monitor and 
        //change their order as needed.
        ConsistencyInspector ci = new ConsistencyInspector();
        ci.reset();
        for (int i = 0; i < currentOrder.size(); i++) {
            GelCap pill = currentOrder.get(i);
            //call accept in double dispatch to get the GelCap type
            pill.accept(ci);
        }
        return ci.soFarConsistent();
    }

    /*
     * Removes a pill from the current order ArrayList.
     * 
     * @param index the index of the pill to be removed.
     */
    public void removePill(int index) {
        currentOrder.remove(index);
    }

    /*
     * Returns the size of the current order ArrayList.
     * 
     * @return the size of the currentOrder ArrayList
     */
    public int getOrderSize() {
        return currentOrder.size();
    }
}
