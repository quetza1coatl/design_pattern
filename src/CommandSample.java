public class CommandSample {
    public static void main(String[] args) {
        Command command1 = new LightCommand(new Light());
        Command command2 = new MusicPlayerCommand(new MusicPlayer());
        Command command3 = new LightAndMusicPlayerCommand(new Light(), new MusicPlayer());
        Command command4 = new PhoneCommand(new Phone(), "00029939554545");
        Button btn = new Button(command4);
        btn.pressButton();
    }
}

class Button{
    private Command command;
    Button(Command command) {
        this.command = command;
    }

    void pressButton(){
        command.execute();
    }
}

interface Command{
    void execute();
}

class LightCommand implements Command{
    private Light light;

    LightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchLight();
    }
}

class MusicPlayerCommand implements Command{
    private MusicPlayer player;

    MusicPlayerCommand(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.play();
    }
}

// combo
class LightAndMusicPlayerCommand implements Command{
    private Light light;
    private MusicPlayer player;

    LightAndMusicPlayerCommand(Light light, MusicPlayer player) {
        this.light = light;
        this.player = player;
    }

    @Override
    public void execute() {
        light.switchLight();
        player.play();
    }
}

// pass parameters
class PhoneCommand implements Command{
    private Phone phone;
    private String phoneNumber;

    PhoneCommand(Phone phone, String phoneNumber) {
        this.phone = phone;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void execute() {
        phone.makeCall(phoneNumber);
    }
}



class Light{
    private boolean isOn;
    void switchLight(){
        this.isOn = !this.isOn;
        System.out.println("Light is "+ (isOn? "on" : "off"));
    }
}

class MusicPlayer{
    void play(){
        System.out.println("Play music");
    }
}

class Phone{
    void makeCall(String phoneNumber){
        System.out.println("Make call to " + phoneNumber);
    }
}
