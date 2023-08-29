import java.util.Scanner;

public class ExpressionGenerator {
  private static int maxDepth;
  
  public static int randInt(int min, int max) {
    return (int) (Math.random() * ((max + 1) - min)) + min;
  }

  /*
   * < Digit > ::= "0" | "1" | "2" | ... | "9"
   */
  public static String digit(int depth) {
    return Character.toString((char) ('0' + randInt(0, 9)));
  }

  /*
   * < Number > ::= < Number > < Digit >
   * | < Digit >
   */
  public static String number(int depth) {
    int rule;
    if(depth >= maxDepth) {
      rule = 2;
    } else {
      rule = randInt(1,2);
    }
    
    if (rule == 1) {
      return number(depth+1) + digit(depth+1);
    } else {
      return digit(depth+1);
    }
  }

  /*
   * < Expression > ::= < Expression > "+" < Expression >
   * | < Expression > "-" < Expression >
   * | < Expression > "*" < Expression >
   * | < Expression > "/" < Expression >
   * | < Number >
   */
  public static String expression(int depth) {
    int rule;
    if(depth >= maxDepth) {
      rule = 5;
    } else {
      rule = randInt(1,5);
    }
    
    switch(rule) {
      case 1:
        return expression(depth+1) + "+" + expression(depth+1);
      case 2:
        return expression(depth+1) + "-" + expression(depth+1);
      case 3:
        return expression(depth+1) + "*" + expression(depth+1);
      case 4:
        return expression(depth+1) + "/" + expression(depth+1);
      default:
        return number(depth+1);
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Max Depth: ");
    maxDepth = scan.nextInt();
    
    for (int i = 0; i < 1000; i++) {
      System.out.println(expression(0));
    }
  }
}