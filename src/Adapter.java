public class Adapter {
    public static void main(String[] args) {
        AmericanSocket americanSocket = new SimpleAmericanSocket();
        Radio radio = new Radio();
        EuroSocket euroSocket = new AmericanToEuropeSocketAdapter(americanSocket);
        radio.turnOn(euroSocket);
    }
}
interface EuroSocket{
    void getPower();
}

interface AmericanSocket{
    void getPower();
}

class SimpleAmericanSocket implements AmericanSocket{
    @Override
    public void getPower() {
        System.out.println("Get 110V");
    }
}

class AmericanToEuropeSocketAdapter implements EuroSocket{
    private AmericanSocket americanSocket;

     AmericanToEuropeSocketAdapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }


    @Override
    public void getPower() {
        americanSocket.getPower();
    }
}

class Radio{
    void turnOn  (EuroSocket euroSocket){
        euroSocket.getPower();
        System.out.println("Radio is turned on");
    }
}
