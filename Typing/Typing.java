public class Typing {
  public static void main(String[] args) {
    int i;
    double d;
    char c;
    String s;

    // attempt to assign an integer to a double
    i = 1;
    d = i;
    System.out.println(d);

    // mix types together
    System.out.println(1 + 1.5);

    // attempt to assign a double to an integer
    d = 1.5;
    i = (int) d;
    System.out.println(i);

    // attempt to assign a double to a character
    d = 65.9999999;
    c = (char) d;
    System.out.println(c);

    // what about strings?
    s = "String: ";
    s = s + d;
    System.out.println(s);
  }
}