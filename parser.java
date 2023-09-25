public class Parser
  {
    private Lexer lexer;

    public Parser (Lexer lexer){
      this.lexer=lexer();
      
    }
    public void parse(){
      this.lexer.next();
      //parse_program
    }
  }