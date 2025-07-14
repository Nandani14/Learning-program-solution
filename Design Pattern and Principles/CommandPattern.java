// Command Pattern Example - Turning lights on/off using a remote

// Step 1: Command interface
interface Command {
    void execute();
}

// Step 2: Receiver class (actual device)
class Light {
    public void turnOn() {
        System.out.println("The light is ON 💡");
    }

    public void turnOff() {
        System.out.println("The light is OFF ❌");
    }
}

// Step 3: Concrete Commands
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

// Step 4: Invoker class (remote control)
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        }
    }
}

// Step 5: Main app
public class CommandPattern {
    public static void main(String[] args) {
        Light roomLight = new Light();
        Command turnOn = new LightOnCommand(roomLight);
        Command turnOff = new LightOffCommand(roomLight);

        RemoteControl remote = new RemoteControl();

        System.out.println("Nandani presses the ON button:");
        remote.setCommand(turnOn);
        remote.pressButton();

        System.out.println("\nNandani presses the OFF button:");
        remote.setCommand(turnOff);
        remote.pressButton();
    }
}

