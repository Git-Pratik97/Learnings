package designPatterns.behavioral;

public class CommandDesign {
    public static void main(String[] args) {
        Light light = new Light(); //Create a receiver
        Fan fan = new Fan();

        Command lightOn = new LightOnCommand(light); //Creating commands
        Command lightoff = new LightOffCommand(light);
        Command fanOn = new FanOnCommand(fan);
        Command fanOff = new FanOffCommand(fan);

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(lightOn);
        remoteControl.pressButton();

        remoteControl.setCommand(lightoff);
        remoteControl.pressButton();

        remoteControl.setCommand(fanOn);
        remoteControl.pressButton();

        remoteControl.setCommand(fanOff);
        remoteControl.pressButton();
    }
}

//Command Interface
interface Command{
    void execute();
}

//Receivers (Light and Fan)
class Light{
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

class Fan{
    public void turnOn() {
        System.out.println("Fan is Spinning");
    }

    public void turnOff() {
        System.out.println("Fan is stopped");
    }
}

//Concrete Command Classes
class LightOnCommand implements Command{
    private Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command{
    private Light light;

    public LightOffCommand(Light light){
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

class FanOnCommand implements Command{
    private Fan fan;

    public FanOnCommand(Fan fan){
        this.fan = fan;
    }

    public void execute(){
        fan.turnOn();
    }
}

class FanOffCommand implements Command{
    private Fan fan;
    public FanOffCommand(Fan fan){
        this.fan = fan;
    }

    public void execute() {
        fan.turnOff();
    }
}

//Invoker
class RemoteControl{
    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}