public class FacadeSample {
    public static void main(String[] args) {
        RoomFacade room = new RoomFacade();
        room.pressButton("F11", 24);
    }
}

class RoomFacade{
    private Tv tv = new Tv();
    private Light1 light = new Light1();
    private AirConditioning cond = new AirConditioning();

    void pressButton(String channel, Integer temperature){
        tv.playChannel(channel);
        light.lightOn();
        cond.setTemperature(temperature);
    }
}

class Tv{
    void playChannel(String channel){
        System.out.println("play channel " + channel);
    }
}
class Light1{
    void lightOn(){
        System.out.println("Light on");
    }
}
class AirConditioning{
    void setTemperature(Integer temperature){
        System.out.println("Set temperature " + temperature);
    }
}
