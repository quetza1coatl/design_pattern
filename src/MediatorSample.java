import java.util.ArrayList;
import java.util.List;

public class MediatorSample {
    public static void main(String[] args) {
        Chat chat = new ChatMediator();
        Colleague mike = new ColleagueImpl(chat, "Mike");
        chat.addColleague(mike);
        chat.addColleague(new ColleagueImpl(chat, "Bron"));
        chat.addColleague(new ColleagueImpl(chat, "James"));
        mike.sendMessage("hi!");
    }
}

interface Chat{
    void sendMessage(String message, Colleague  sender);
    void addColleague(Colleague  colleague);
}

class ChatMediator implements Chat{
    private List<Colleague > list = new ArrayList<>();
    @Override
    public void sendMessage(String message, Colleague  sender) {
        list.forEach(colleague  -> {
            if(colleague  != sender){
                colleague.printMessage(message);
            }
        });
    }

    @Override
    public void addColleague (Colleague  colleague) {
        list.add(colleague );
    }
}

abstract class Colleague{
    Chat chat;
    String name;
    Colleague (Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    abstract void sendMessage(String message);
    abstract void printMessage(String message);
}

class ColleagueImpl extends Colleague {

    ColleagueImpl(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    void printMessage(String message) {
        System.out.println(name + ": " + message);
    }
}
