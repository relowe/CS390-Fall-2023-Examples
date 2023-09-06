/**
 * Lexer for the calc language
 */
public class Lexer
{
    /// Source of the character stream
    private InputStream file;        

    /// Current character being matched
    private char cur;

    /// Current Lexeme
    private Lexeme curLex;

    /// Line and column number of input
    private int line;
    private int col;

    /// Construct a lexer for the given input stream
    public Lexer(InputStream file) 
    {
        this.file = file;     
        this.line = 1;
        this.col = 0;
        read();
    }

    
    public Lexeme next()
    {
        if(match_single()) return curTok;

        // invalid
        curTok = Lexeme(Token.INVALID, Character.toString(cur), line, col);
        read();
        return curTok;
    }

    /// Match our single character tokens
    /// Return true on success, false on failure.
    public boolean match_single()
    {
        Token tok;
        
        switch(cur) {
            case '+':
                tok = Token.PLUS;
                break;
            case '-':
                tok = Token.MINUS;
                break;
            case '*':
                tok = Token.TIMES;
                break;
            case '/':
                tok = Token.DIVIDE;
                break;
            case '^':
                tok = Token.POW;
                break;
            case '(':
                tok = Token.LPAREN;
                break;
            case ')':
                tok = Token.RPAREN;
                break;
            case '\n':
                tok = Token.NEWLINE;
            default:
                tok = Token.INVALID;
        }

        // did not match
        if(tok == Token.INVALID) {
            return false;
        }

        // match
        curTok = new Lexeme(tok, Character.toString(cur), line, col);
        read();
        return true;
    }
    
    /// Read the next character
    private void read()
    {
        //handle newline
        if(cur == '\n') {
            line++;
            col=0;
        }
        cur = file.read();
        col++;
    }

    public static void main(String [] args) {
        Lexer lex = new Lexer(System.in);

        while(true) {
            System.out.println(lex.next());
        }
    }
}