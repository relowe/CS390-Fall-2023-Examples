  public class Parser
{
  private Lexer lexer;    

  public Parser(Lexer lexer) {
    this.lexer = lexer;
  }

  public void parse() {
    this.lexer.next();  //linitialize the lexer
    parseProgram();
  }

  /**
   Attempt to match tok.
   If it matches, return the lexeme. If it does not match, return null.
   */
  private Lexeme match(Token tok) {
    Lexeme l = lexer.cur();
    if(l.tok == tok) {
      // match, advance lexer, return the match
      lexer.next();
      return l;
    } 

    // no match
    return null;
  }


  /**
   * Attempt to match a token. Returns lexeme on match, halts the program on failure.
   */
  private Lexeme mustBe(Token tok) {
    Lexeme l = match(tok);

    if(l == null) {
      System.out.println("Parse Error: " + lexer.cur().toString());
      System.exit(-1);
    }

    return l;
  }


  /**
  < Program >    ::= < Program > < Statement >
                   | < Statement >
   */
  private void parseProgram() {
    while(lexer.cur().tok != Token.EOF) {
      parseStatement();
    }
  }


  /**
  < Statement >  ::= < Expression > NEWLINE
  */
  private void parseStatement() {
    parseExpression();
    mustBe(Token.NEWLINE);
  }

  /**
  < Term >       ::= < Factor > < Term' >
  */
  private void parseTerm() {
    parseFactor();
    parseTerm2();
  }
  
  /**
  < Term' >      ::= TIMES < Factor > < Term' >
                   | DIVIDE < Factor > < Term' >
                   | MOD < Factor > < Term' >
                   | ""
  */
  private void parseTerm2() {
    if(match(Token.TIMES) != null) {
        parseFactor();
        parseTerm2();
        return;
    } else if(match(Token.DIVIDE) != null) {
        parseFactor();
        parseTerm2();
        return;
    } else if(match(Token.MOD) != null) {
        parseFactor();
        parseTerm2();
        return;
    }
    
  }

  /** 
  < Number >     ::= INTLIT | REALLIT
  */
  private void parseNumber() {
    if (match(Token.INTLIT) != null) {
      return;
    }

    mustBe(Token.REALLIT);
  }

  

  
  /**
    < Exponent >   ::= < Number >
                   | MINUS < Exponent >
                   | LPAREN < Expression > RPAREN
  */

  private void parseExponent(){
    if(match(Token.MINUS) != null){
      parseExponent();
      return;
    } else if(match(Token.LPAREN) != null){
      parseExpression();
      mustBe(Token.RPAREN);
      return;
    } else {
      parseNumber();
      return;
    }
  }

// < Expression > ::= < Term > < Expression' >
  
 private void parseExpression() {
    parseTerm();
    parseExpression2();
 }
  
/**
< Expression' > ::= PLUS < Term > < Expression' >
                   | MINUS < Term > < Expression' >
                   | ""
 */


public void parseExpression2(){
  if (match(Token.PLUS) != null){
    parseTerm();
    parseExpression2();
    return;
  } else if (match(Token.MINUS) != null){
    parseTerm();
    parseExpression2();
    return;
  } 
}

/*
< Factor >     ::= < Exponent > < Factor' >

*/
public void parseFactor(){
  parseExponent();
  parseFactor2();
  return;
}


  /**
   < Factor' >    ::= POW < Exponent > < Factor' >
                      | ""
   */
public void parseFactor2(){
  if (match(Token.POW) != null){
    parseExponent();
    parseFactor2();
    return;
  }
}

  /** 
   * Test the parser
   */
  public static void main(String [] args) {
    Lexer lexer = new Lexer(System.in);
    Parser parser = new Parser(lexer);

    parser.parse();
  }
}