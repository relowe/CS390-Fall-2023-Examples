import java.util.Scanner;

class Main {
  public static void main(String[] args) {
      int x;
      Scanner scan = new Scanner(System.in);

      System.out.print("x=");
      x = scan.nextInt();

      System.out.printf("-x=%d\n+x=%d\n", -x, +x);
  }
}