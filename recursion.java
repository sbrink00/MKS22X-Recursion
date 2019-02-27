import java.util.ArrayList;
public class recursion{
  public static void main(String[]args){
    /*System.out.println("square root helper method testing:");
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
    System.out.println("------------------------------------------------");
    System.out.println("testing fibHelper method:");
    System.out.println(fibHelper(0, 200, 389231, 323));
    System.out.println(fibHelper(1, 200, 389231, 323));
    System.out.println(fibHelper(2, 1, 0, 2));
    System.out.println(fibHelper(14, 1, 0, 2) + "should be 377");
    System.out.println(fibHelper(46, 1, 0, 2) + " (should be 1836311903)");
    System.out.println("------------------------------------------------");
    System.out.println("testing fib method. Should return the same values as fibHelper");
    System.out.println(fib(0));
    System.out.println(fib(1));
    System.out.println(fib(2));
    System.out.println(fib(14) + " (should be 377)");
    System.out.println(fib(46) + " (should be 1836311903)");
    System.out.println("------------------------------------------------");
    System.out.println("testing makeAllSums method");
    System.out.println(makeAllSums(0));
    System.out.println(makeAllSums(1));
    System.out.println(makeAllSums(2));
    System.out.println(makeAllSums(3));
    System.out.println(makeAllSums(4));
    //included this for loop so that I could test to make sure the size
    //of the output of makeAllSums for all values of n from 0 to 24
    //is equal to 2^n. Anything above 24 took too long to run.
    for (int idx = 0; idx < 24; idx ++){
      if (makeAllSums(idx).size()!=(int)Math.pow(2, idx))System.out.println(false);
    }*/
    testFib(4);
    testSqrt(4);
  }

  public static ArrayList<Integer> makeAllSums(int n){
    ArrayList<Integer> output = new ArrayList<Integer>();
    output.add(0);
    if (n == 0) return output;
    else{
      output = makeAllSums(n - 1);
      int currentSize = output.size();
      for (int idx = 0; idx < currentSize; idx ++) output.add(output.get(idx) + n);
    }
    return output;
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

  public static int fib(int n){
    return fibHelper(n, 1, 0, 2);
  }

  //n is the place of the fibonacci numer we want to find.
  //currentNum is the current place in the sequence that the method is at.
  //prev is the previous fibonacci number from currentNum.
  //behindPrev is the fibonacci number before prev.
  //this works up to 46, but once you make n 47, the value is too large to be stored in an int.
  private static int fibHelper(int n, int prev, int behindPrev, int currentNum){
    if (n < 2) return n;
    if (currentNum == n) return prev + behindPrev;
    else return fibHelper(n, prev + behindPrev, prev, currentNum + 1);
  }

  public static boolean closeEnough(double a, double b){
    if(a==0.0 && b==0.0)return true;
    if(a==0.0)return b < 0.00000000001;
    if(b==0.0)return a < 0.00000000001;
    return Math.abs(a-b)/a < 0.0001;//This is the normal % difference allowed

}


//testcase must be a valid index of your input/output array
public static void testFib(int testcase){
  recursion r = new recursion();
  int[] input = {0,1,2,3,5,30};
  int[] output ={0,1,1,2,5,832040};
  int max = input.length;
  if(testcase < input.length){
    int in = input[testcase];
    try{

      int ans = r.fib(in);
      int correct = output[testcase];
      if(ans == correct){
        System.out.println("PASS test fib "+in+". "+correct);
      }
      else{
        System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);

      }
    }catch(IllegalArgumentException n){
      if(in < 0){
        System.out.println("PASS test fib"+in+" IllegalArgumentException");
      }else{
        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
      }
    }catch(Exception e){
      System.out.println(" FAIL Some exception in test case:"+in);
    }
  }
}


//testcase must be a valid index of your input/output array
public static void testSqrt(int testcase){
  recursion r = new recursion();
  double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
  double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
  int max = input.length;
  if(testcase < input.length){
    double in = input[testcase];
    try{

      double ans = r.sqrt(in,.00001);
      double correct = Math.sqrt(in);
      if(closeEnough(ans,correct)){
        System.out.println("PASS test sqrt "+in+" "+ans);
      }
      else{
        System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);

      }
    }catch(IllegalArgumentException n){
      if(in < 0){
        System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
      }else{
        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
      }
    }catch(Exception e){
      System.out.println(" FAIL Some exception in test case:"+in);
    }
  }
}

}
