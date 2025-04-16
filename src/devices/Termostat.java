package devices;

public class Termostat extends Device{

    private int temperature;

    public Termostat(Protocol protocol, String name) {
        super(protocol, name, Device.Type.TERMOSTAT);
    }
    public void setTemperature(int temperature) {
            this.temperature = temperature;
    }
    public int getTemperature() {return temperature;}
}
