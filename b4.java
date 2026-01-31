interface Connectable {
    void connectWifi();
}

interface Chargeable {
    void charge();
}

abstract class Device {
    protected int id;
    protected String name;

    public Device(int id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract void turnOn();
    abstract void turnOff();
}

class SmartPhone extends Device implements Connectable, Chargeable {

    public SmartPhone(int id, String name) {
        super(id, name);
    }

    void turnOn() {
        System.out.println(name + " turned on");
    }

    void turnOff() {
        System.out.println(name + " turned off");
    }

    public void connectWifi() {
        System.out.println(name + " connected to wifi");
    }

    public void charge() {
        System.out.println(name + " is charging");
    }
}

class Laptop extends Device implements Connectable, Chargeable {

    public Laptop(int id, String name) {
        super(id, name);
    }

    void turnOn() {
        System.out.println(name + " turned on");
    }

    void turnOff() {
        System.out.println(name + " turned off");
    }

    public void connectWifi() {
        System.out.println(name + " connected to wifi");
    }

    public void charge() {
        System.out.println(name + " is charging");
    }
}

class Television extends Device implements Connectable {

    public Television(int id, String name) {
        super(id, name);
    }

    void turnOn() {
        System.out.println(name + " turned on");
    }

    void turnOff() {
        System.out.println(name + " turned off");
    }

    public void connectWifi() {
        System.out.println(name + " connected to wifi");
    }
}

public class Main {
    public static void main(String[] args) {

        Device[] devices = new Device[3];

        devices[0] = new SmartPhone(1, "iPhone");
        devices[1] = new Laptop(2, "Dell");
        devices[2] = new Television(3, "Samsung TV");

        for (Device d : devices) {
            d.turnOn();

            if (d instanceof Connectable) {
                ((Connectable) d).connectWifi();
            }

            if (d instanceof Chargeable) {
                ((Chargeable) d).charge();
            }

            d.turnOff();
            System.out.println();
        }
    }
}
