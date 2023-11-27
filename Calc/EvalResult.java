public class EvalResult 
{
  private EvalType type;
  private int i;
  private double d;
  private boolean b;
  private RecordDeclaration recordDecl;

  public EvalResult() {
    type = EvalType.VOID;
  }
  
  // set the value of the object and infer its type
  public void setValue(int value) {
    type = EvalType.INTEGER;
    i=value;
  }

  public void setValue(double value) {
    type = EvalType.REAL;
    d = value;
  }


  public void setValue(boolean value) {
    type = EvalType.BOOLEAN;
    b = value;
  }


  public void setValue(RecordDeclaration recordDecl) {
    type = EvalType.RECORD_DECL;
    this.recordDecl = recordDecl;
  }


  public int asInteger() {
    if(type == EvalType.INTEGER) {
      return i;
    } else {
      return (int) d;
    }
  }


  public double asReal() {
    if(type == EvalType.REAL) {
      return d;
    } else {
      return (double) i;
    }
  }


  public boolean asBoolean() {
    return b;
  }

  public RecordDeclaration asRecordDecl() {
    return recordDecl;
  }


  public EvalType getType() {
    return type;
  }



  public String toString() {
    if(type == EvalType.INTEGER) {
      return ""+i;
    } else {
      return ""+d;
    }
  }
  
}
