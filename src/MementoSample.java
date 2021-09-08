import java.util.ArrayList;
import java.util.List;

public class MementoSample {
    public static void main(String[] args) {
        List<Originator.Memento> list = new ArrayList<>();
        Originator originator = new Originator();
        originator.setState("0");
        originator.setState("1");
        list.add(originator.saveState());
        originator.setState("2");
        System.out.println(originator.getState());  // 2
        originator.restoreFromMemento(list.get(0));
        System.out.println(originator.getState());  // 1

    }
}

class Originator{
    private String state;
    Memento saveState(){
        return new Memento(getState());
    }

    void restoreFromMemento(Memento memento){
        setState(memento.getState());
    }

    String getState() {
        return state;
    }

    void setState(String state) {
        this.state = state;
    }

    static class Memento{
        private String state;

        Memento(String state) {
            this.state = state;
        }

        String getState() {
            return state;
        }
    }
}
