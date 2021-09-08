import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ObserverSample {
    public static void main(String[] args) {
        CustomSubject customSubject = new CustomSubject();
        customSubject.subscribe(new CustomSubscriber1());
        customSubject.subscribe(new CustomSubscriber2());
        customSubject.notifySubscribers("hello");

        // JDK impl
        Subject subject = new Subject();
        subject.addObserver(new Subscriber1());
        subject.addObserver(new Subscriber2());
        subject.setChanged();
        subject.notifyObservers("hi");
    }
}

interface CustomObservable {
    void call(String message);
}

class CustomSubscriber1 implements CustomObservable {

    @Override
    public void call(String message) {
        System.out.println("s1_custom:" + message);
    }
}

class CustomSubscriber2 implements CustomObservable {

    @Override
    public void call(String message) {
        System.out.println("s2_custom:" + message);
    }
}

class CustomSubject {
    List<CustomObservable> subscribers = new ArrayList<>();

    void subscribe(CustomObservable customObservable){
        subscribers.add(customObservable);
    }

    public void unsubscribe(CustomObservable customObservable){
        subscribers.remove(customObservable);
    }

    void notifySubscribers(String msg){
        subscribers.forEach(s -> s.call(msg));
    }
}

// JDK impl
class Subject extends Observable{
    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }
}

class Subscriber1 implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("s1:" + arg);
    }
}

class Subscriber2 implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("s2:" + arg);
    }
}
