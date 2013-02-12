package  wci.frontend;

import wci.intermediate.ICode;
import wci.intermediate.SymTab;
import wci.message.*;

public abstract class Parser implements MessageProducer {
    protected static Symtab symtab;
    protected static MessageHandler messageHandler;

    static {
        symtab = null;
        messageHandler = new MessageHandler();
    }

    public void addMessageListener(MessageListener listener)
    {
        messageHandler.addListener(listener);
    }

    public void removeMessageListener(MessageListener listener)
    {
        messageHandler.removeListener(listener);
    }

    public void sendMessage(Message message)
    {
        messageHandler.sendMessage(message);
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
