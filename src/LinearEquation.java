

public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    //constructor
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    //Methods
    //slope function
    public double slope() {
        int rise = y2 - y1;
        int run = x2 - x1;
        if (run == 0) {
            return 0; //fail safe
        } else {
            return roundedToHundredth((double) rise / run);
        }
    }
    //y intercept function
    public double yIntercept() {
        return roundedToHundredth(y1 - (slope() * x1));
    }
    //distance between (x1, y1) and (x2, y2)
    public double distance() {
        double x3 = Math.pow(x2 - x1, 2);
        double y3 = Math.pow(y2 - y1, 2);
        return roundedToHundredth(Math.sqrt(x3 + y3));
    }
    //print out the points
    public String twoPoints() {
        return "The two points are (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
    }
    //print info
    public String lineInfo() {
        String retString = "";
        retString += twoPoints() + "\n";
        retString += "The equation of the line between these points is: " + equation() + "\n";
        retString += "The y-intercept of this line is: " + yIntercept() + "\n";
        retString += "The slope of this line is: " + slope() + "\n";
        retString += "The distance between the two points is: " + distance() + "\n";
        return retString;
    }
    //print the equation
    public String equation() { //EC included
        String equation = "y = ";
        //y = mx + b
        //x should not be in the equation if slope() = 0
        if (slope() != 0) {
            //Sign: should be determined by whether slope is positive or negative
            if (slope() < 0) {
                equation += "-";
            }
            //Fraction: if abs value of slope = 1, put nothing there.
            if (Math.abs(slope()) != 1) {
                //if slope is an integer, don't put it as a fraction
                if (slope() == (int)slope()) {
                    equation += "" + (int) Math.abs(slope());
                }
                // if slope isn't an integer and doesn't equal 1 or -1 or 0, put it as a fraction.
                else {
                    equation += Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1);
                }
            }
            //put in x
            equation += "x ";
            //adding the y intercept. don't add anything if y intercept = 0
            if (yIntercept() != 0) {
                if (yIntercept() > 0) {
                    equation += "+ ";
                } else if (yIntercept() < 0) {
                    equation += "- ";
                }
                equation += Math.abs(yIntercept());
            }
        } else { //slope = 0
            equation += "" + (int) yIntercept();
        }
        return equation;
    }
    //coordinate of X
    public String coordinateForX(double x) {
        double y = roundedToHundredth(slope() * x + yIntercept());
        return "(" + x + ", " + y + ")";
    }
    //round to a hundredth: EC
    public double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}
