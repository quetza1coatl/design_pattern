public class ChainOfResponsibilitySample {
    public static void main(String[] args) {
        MessageHandler handler = new MessageVerifyHandler(
                new MessageAddExclamationMarkHandler(
                        new MessagePrinterHandler(null)
                )
        );
        handler.handle("Hi4");
        handler.handle("Hi");
    }
}

abstract class MessageHandler{
    MessageHandler handler;
    MessageHandler(MessageHandler handler) {
        this.handler = handler;
    }
    abstract void handle(String msg);
}

class MessagePrinterHandler extends MessageHandler{

    MessagePrinterHandler(MessageHandler handler) {
        super(handler);
    }

    @Override
    void handle(String msg) {
        System.out.println(msg);
    }
}

class MessageVerifyHandler extends MessageHandler{

    MessageVerifyHandler(MessageHandler handler) {
        super(handler);
    }

    @Override
    void handle(String msg) {
        if(!msg.matches(".*\\d.*")){
            handler.handle(msg);
            // chain is breaks here
        }
    }
}

class MessageAddExclamationMarkHandler extends MessageHandler{

    MessageAddExclamationMarkHandler(MessageHandler handler) {
        super(handler);
    }

    @Override
    void handle(String msg) {
        handler.handle(msg + "!");
    }
}
