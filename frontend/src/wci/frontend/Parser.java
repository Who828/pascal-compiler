package  wci.frontend;

import wci.intermediate.ICode;
import wci.intermediate.SymTab;

public abstract class Parser {
    protected static Symtab symtab;

    static {
        symtab = null;
    }
    protected Scanner scanner;
    protected ICode iCode;

    protected Parser(Scanner scanner)
    {
        this.scanner = scanner;
        this.iCode = null;
    }

    public abstract void parse()
        throws Exception;

    public abstract int getErrorCount();

    public Token currentToken()
    {
        return scanner.currentToken();
    }

    public Token nextToken()
        throws Exception
    {
        return scanner.nextToken();
    }
}
