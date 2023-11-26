public class Display extends UnaryOp {
  public EvalResult eval(RefEnv env) {
    System.out.println(getChild().eval(env));
    return null;
  }

  public void print(int depth) {
    getChild().print(depth + 1);
    System.out.printf("%" + (depth + 1) + "sdisplay\n", "");
  }
  
  
}