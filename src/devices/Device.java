package devices;

import java.util.ArrayList;
import java.util.List;

public abstract class Device {
    
    public String name;
    private Status status = Status.OFF;
    private final Protocol protocol;
    public final Type type;

    public enum Status {
        ON, OFF
    }
    public enum Protocol {
        BLUETOOTH, WIFI
    }
    public static enum Type {
        Light, Termostat
    }

    public Device(Protocol protocol, String name, Type type) {
        this.protocol = protocol;
        this.type = type;
        this.name = name;
    }

    public Status getStatus() {return status;}
    public void setStatus(Status status) {this.status = status;}
    public Protocol getProtocol() {return protocol;}
    public abstract Device copy();
    public abstract boolean setProprety(String proprety, String value);

    
}