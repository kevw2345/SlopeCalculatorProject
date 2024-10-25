import java.util.Scanner;


public class LinearEquationLogic {
    private Scanner scan = new Scanner(System.in);
    private LinearEquation equation = new LinearEquation(0, 0,0, 0);
    //constructor
    public LinearEquationLogic() {
    }
    //Methods
    //start
    public void start() {
        boolean cont = true;
        System.out.println("Welcome to the linear equation calculator!");
        while(cont) {
            initializeEquation();
            System.out.println("\n" + equation.lineInfo());
            System.out.print("\nEnter a value for x: ");
            double x = scan.nextDouble();
            scan.nextLine();
            System.out.println("\nThe point on the line is " + equation.coordinateForX(x));
            System.out.print("\nWould you like to enter another pair of coordinates? y/n: ");
            cont = !(scan.nextLine().equalsIgnoreCase("n"));
        }
        System.out.println("\nThank you for using the slope calculator. Goodbye!");
    }
    //initialize the LinearEquation
    private void initializeEquation() {
        int[] pair1;
        int[] pair2;
        do {
            System.out.print("Enter a valid coordinate pair: ");
            pair1 = parsePair(scan.nextLine());
            System.out.print("Enter another valid coordinate pair: ");
            pair2 = parsePair(scan.nextLine());
            //prevents invalid slopes
            if (pair1[0] == pair2[0]) {
                System.out.println("\nBoth of your coordinates must have different x-values.\n");
            }
        }
        while (pair1[0] == pair2[0]);
        //sets up the linear equation
        equation = new LinearEquation(pair1[0], pair1[1], pair2[0], pair2[1]);
    }
    //parse a coordinate pair
    private int[] parsePair(String pair) {
        String xValStr = "";
        boolean loop = true;
        for (int x = 1; loop; x++) {
            //adds the current character to the number string if it is a number. else, ends the loop
            if(Character.isDigit(pair.charAt(x)) || pair.charAt(x) == '-') {
                xValStr += pair.charAt(x);
            } else {
                loop = false;
            }
        }
        int xVal = Integer.parseInt(xValStr);
        //loop again, but for the y value
        String yValStr = "";
        loop = true;
        for (int x = 3 + xValStr.length(); loop; x++) {
            //adds the current character to the number string if it is a number. else, ends the loop
            if(Character.isDigit(pair.charAt(x)) || pair.charAt(x) == '-') {
                yValStr += pair.charAt(x);
            } else {
                loop = false;
            }
        }
        int yVal = Integer.parseInt(yValStr);
        int[] xy = {xVal, yVal};
        return xy;
    }
}
