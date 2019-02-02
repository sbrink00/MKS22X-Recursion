public class recursion{
  public static void main(String[]args){
    System.out.println("square root helper method testing:");
    System.out.println(sqrtHelper(100, 1, .001));
    System.out.println(sqrtHelper(.25, 1, .001));
    System.out.println(sqrtHelper(64, 1, .001));
    System.out.println(sqrtHelper(2, 1, .001));
    System.out.println("------------------------------------------------");
    System.out.println("square root testing. Should return the same thing as the helper method");
    System.out.println(sqrt(100, .001));
    System.out.println(sqrt(.25, .001));
    System.out.println(sqrt(64, .001));
    System.out.println(sqrt(2, .001));

  }

  public static double sqrt(double n, double tolerance){
    return sqrtHelper(n, 1, tolerance);
  }

  private static double sqrtHelper(double n, double guess, double tolerance){
    if (n == 0) return 0;
    //uses percent error formula to check whether or not the guess squared is
    //within the tolerance.
    else if (((Math.abs(guess * guess - n) / n) * 100) <= tolerance) return guess;
    else return sqrtHelper(n, ((n / guess + guess) / 2), tolerance);
  }

  //n is the place of the fibonacci numer we want to find.
  //currentNum is the current place in the sequence that the method is at.
  //prev is the previous fibonacci number from currentNum.
  //behindPrev is the fibonacci number before prev.
  private static int fibHelper(int n, int prev, int behindPrev, int currentNum){
    if (n < 2) return n;
    if (currentNum == n) return prev + behindPrev;
    else return fibHelper(n, prev + behindPrev, prev, currentNum + 1);
  }

}
