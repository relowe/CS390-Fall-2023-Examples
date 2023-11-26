public class Nested {
  public static void main(String [] args) {
    int x = 5;

    public static int g() {
      x = x+1;
      return x;
    }

    g();
  }
}