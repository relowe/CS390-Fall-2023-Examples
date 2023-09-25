import java.io.IOException;
import java.io.InputStream;

/**
 * Lexer for the calc language
 */
public class Lexer {
    /// Source of the character stream
    private InputStream file;

    /// Current character being matched
    private char cur;

    /// Current Lexeme
    private Lexeme curLex;

    /// Line and column number of input
    private int line;
    private int col;
    private int startLine;
    private int startCol;
    private boolean eof;

    /// The lexeme that we are accumulating
    private StringBuilder curString;

    /// Construct a lexer for the given input stream
    public Lexer(InputStream file) {
        this.file = file;
        this.line = 1;
        this.col = 0;
        this.eof = false;
        read();
    }


    private void setToken(Token tok) {
        curLex = new Lexeme(tok, curString.toString(), startLine, startCol);
    }

    // skip characters we wish to ignore
    private void skip() {
        // skip all the blank characters
        while(cur != '\n' && Character.isSpaceChar(cur)) {
            read();
        }
    }

    public Lexeme next() {
        // start the matching
        skip();
        curString = new StringBuilder();
        startLine = line;
        startCol = col;

        // handle eof
        if(eof) {
            setToken(Token.EOF);
            return curLex;
        }

        if (match_single())
            return curLex;
        else if(match_number())
            return curLex;
        else if(matchWord())
            return curLex;
        else
            consume();

        // invalid
        setToken(Token.INVALID);
        return curLex;
    }

    /// Match our single character tokens
    /// Return true on success, false on failure.
    public boolean match_single() {
        Token tok;

        switch (cur) {
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
            break;
        default:
            tok = Token.INVALID;
        }

        // did not match
        if (tok == Token.INVALID) {
            return false;
        }

        // match
        consume();
        setToken(tok);
        return true;
    }

    /// Match an integer
    private void consumeInteger() {
        while(Character.isDigit(cur)) {
            consume();
        }
    }

    /// Match a Number
    private boolean match_number() {
        if(!Character.isDigit(cur)) return false;

        // this is an integer
        Token tok = Token.INTLIT;
        consumeInteger();

        // check for a dot
        if(cur != '.') {
            setToken(tok);
            return true;
        }

        // it is a dot!
        consume();
        if(Character.isDigit(cur)) {
            tok = Token.REALLIT;
            consumeInteger();
        } else {
            tok = Token.INVALID;
        }
        setToken(tok);
        return true;
    }

    private boolean matchWord() {
        if(!Character.isAlphabetic(cur)) return false;

        //consume letters numbers and _
        while(Character.isDigit(cur) || Character.isAlphabetic(cur) || cur == '_') {
            consume();
        }

        //match against keywords
        String str = curString.toString();
        if(str.equals("MOD")) {
            setToken(Token.MOD);
        } else {
            setToken(Token.INVALID); // in the future, this is a variable
        }

        return true;
    }

    /// Read the next character
    private void read() {
        // handle newline
        if (cur == '\n') {
            line++;
            col = 0;
        }
        try {
            int input = file.read();
            cur = (char) input;
            col++;
            if(input == -1) {
                eof = true;
            }
        } catch(IOException ex) {
            // do nothing for now
            eof = true;
        }
    }

    /// Insert the current character into the curStr
    /// and advanced the lexer
    private void consume() {
        curString.append(cur);
        read();
    }


    public static void main(String[] args) {
        Lexer lex = new Lexer(System.in);
        Lexeme tok;

        do {
            tok = lex.next();
            System.out.println(tok);
        } while(tok.tok != Token.EOF);
    }
}