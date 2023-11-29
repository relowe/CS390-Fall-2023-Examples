public class ArrayDimension extends BinaryOp
{
  public EvalResult eval(RefEnv env)
  {
    //create the array
    int n = getRight().eval(env).asInteger();
    EvalResult [] array = new EvalResult[n];
    EvalResult value = new EvalResult();
    value.setValue(array);

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
