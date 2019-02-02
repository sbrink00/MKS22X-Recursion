public class recursion{
  public static void main(String[]args){
    System.out.println(sqrtHelper(100, 1, .001));
    System.out.println(sqrtHelper(.25, 400, .001));
    System.out.println(sqrtHelper(64, 1, .001));
    System.out.println(sqrtHelper(2, .03, .001));
  }

  public static double sqrt(double n, double tolerance){return 5;}

  private static double sqrtHelper(double n, double guess, double tolerance){
    if (n == 0) return 0;
    //uses percent error formula to check whether or not the guess squared is
    //within the tolerance.
    else if (((Math.abs(guess * guess - n) / n) * 100) <= tolerance) return guess;
    else return sqrtHelper(n, ((n / guess + guess) / 2), tolerance);
  }

}
