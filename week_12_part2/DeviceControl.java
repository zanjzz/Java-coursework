package week_12_part2;

public class DeviceControl {

    public static void main(String[] args) {

        // For light
        Device lightDevice = new Lights(true);
        DeviceProcessor lightProcessor = new DeviceProcessor(lightDevice);

        System.out.println("LIGHTS: ");
        lightProcessor.execute();


        // For sensor
        Device sensorDevice = new Sensors();
        DeviceProcessor sensorProcessor = new DeviceProcessor(sensorDevice);

        System.out.println("\nSENSOR:");
        sensorProcessor.execute();


        // For Actuator
        Device actuatorDevice = new Actuator();
        DeviceProcessor actuatorProcessor = new DeviceProcessor(actuatorDevice);

        System.out.println("\nACTUATOR:");
        actuatorProcessor.execute();
    	
    }
}


// Handles device execution without knowing device type
class DeviceProcessor {
    private Device device;

    DeviceProcessor(Device device) {
        this.device = device;
    }

    void execute() {
        device.perform();
    }
}


// Base abstraction for all devices
interface Device {
    void perform();
}

// Devices that can be turned on/off
interface Switchable {
    void switchPower();
}

// Devices that can execute commands
interface Commandable {
    void executeCommand();
}


// Smart light device
class Lights implements Device, Switchable {
    private boolean isOn;

    Lights(boolean isOn) {
        this.isOn = isOn;
    }

    public void switchPower() {
        System.out.println(isOn ? "Lights turned ON" : "Lights turned OFF");
    }

    public void perform() {
        switchPower();
    }
}


// Sensor device (only detects, no switching needed)
class Sensors implements Device {
    public void perform() {
        System.out.println("Sensor is detecting environment...");
    }
}


// Actuator device (can switch + execute commands)
class Actuator implements Device, Switchable, Commandable {
    public void switchPower() {
        System.out.println("Actuator power toggled");
    }

    public void executeCommand() {
        System.out.println("Actuator executing command...");
    }

    public void perform() {
        switchPower();
        executeCommand();
    }
}