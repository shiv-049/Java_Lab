
// Practical: Demonstrate Multiple Inheritance Using Interfaces
// Real-life example: Smart Device Management System

// Interface 1: Controls device power
interface ControllableDevice {

    void powerOn();

    void powerOff();

    void statusReport();
}


// Interface 2: Provides WiFi connectivity
interface InternetEnabled {

    void connectWifi(String ssid);
}


// Class 1: SmartTV implements both interfaces
class SmartTV implements ControllableDevice, InternetEnabled {

    private boolean isOn = false;
    private String connectedSSID = "None";

    // Turn ON the TV
    public void powerOn() {
        isOn = true;
        System.out.println("SmartTV is powered ON.");
    }

    // Turn OFF the TV
    public void powerOff() {
        isOn = false;
        System.out.println("SmartTV is powered OFF.");
    }

    // Display TV status
    public void statusReport() {
        System.out.println("SmartTV Status: " +
                (isOn ? "ON" : "OFF") +
                ", Connected to: " + connectedSSID);
    }

    // Connect TV to WiFi
    public void connectWifi(String ssid) {
        connectedSSID = ssid;
        System.out.println("SmartTV connected to WiFi: " + ssid);
    }
}


// Class 2: SmartFridge implements both interfaces
class SmartFridge implements ControllableDevice, InternetEnabled {

    private boolean isOn = false;
    private String connectedSSID = "None";

    // Turn ON the fridge
    public void powerOn() {
        isOn = true;
        System.out.println("SmartFridge is powered ON.");
    }

    // Turn OFF the fridge
    public void powerOff() {
        isOn = false;
        System.out.println("SmartFridge is powered OFF.");
    }

    // Display fridge status
    public void statusReport() {
        System.out.println("SmartFridge Status: " +
                (isOn ? "ON" : "OFF") +
                ", Connected to: " + connectedSSID);
    }

    // Connect fridge to WiFi
    public void connectWifi(String ssid) {
        connectedSSID = ssid;
        System.out.println("SmartFridge connected to WiFi: " + ssid);
    }
}


// Class 3: SmartAC implements only ControllableDevice
class SmartAC implements ControllableDevice {

    private boolean isOn = false;

    // Turn ON the AC
    public void powerOn() {
        isOn = true;
        System.out.println("SmartAC is powered ON.");
    }

    // Turn OFF the AC
    public void powerOff() {
        isOn = false;
        System.out.println("SmartAC is powered OFF.");
    }

    // Display AC status
    public void statusReport() {
        System.out.println("SmartAC Status: " +
                (isOn ? "ON" : "OFF"));
    }
}


// Main class
public class SmartDeviceSystem {

    public static void main(String[] args) {

        // Create objects using ControllableDevice reference
        ControllableDevice[] devices = {
            new SmartTV(),
            new SmartFridge(),
            new SmartAC()
        };

        System.out.println("--- CONTROLLING DEVICES ---\n");

        // Perform common operations on all devices
        for (ControllableDevice device : devices) {

            device.powerOn();

            device.statusReport();

            device.powerOff();

            System.out.println();
        }


        // Create objects that support Internet connectivity
        InternetEnabled[] internetDevices = {
            new SmartTV(),
            new SmartFridge()
        };

        System.out.println("--- CONNECTING WIFI ---\n");

        // Connect both devices to WiFi
        for (InternetEnabled device : internetDevices) {

            device.connectWifi("HomeNetwork123");
        }
    }
}
