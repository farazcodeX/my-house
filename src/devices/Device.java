package devices;

public abstract class Device {
    
    String name;
    private Status status = Status.OFF;
    private final Protocol protocol;
    private final Type type;

    public enum Status {
        ON, OFF
    }
    public enum Protocol {
        BLUETOUTH, WIFI
    }
    public enum Type {
        LIGHT, TERMOSTAT
    }
    public Device(Protocol protocol, String name, Type type) {
        this.protocol = protocol;
        this.type = type;
        this.name = name;

    }

    public Status getStatus() {return status;}
    public void setStatus(Status status) {this.status = status;}
    
}