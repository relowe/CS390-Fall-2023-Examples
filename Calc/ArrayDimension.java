public class ArrayDimension extends BinaryOp
{
  public EvalResult eval(RefEnv env)
  {
    //create the array
    int n = getRight().eval(env).asInt();
    EvalResult [] value = new EvalResult[n];

    //store the array
    Variable var = (Variable) getLeft();
    var.set(env, value);
    return new EvalResult();
  }

  public void print(int depth) 
  {
    getRight().print(depth+1);
    System.out.printf("%"+(depth+1)+"sDIMENSION\n", "");
    getLeft().print(depth+1);
  }
}
