package devices;

import java.lang.reflect.InaccessibleObjectException;

public class Termostat extends Device{

    private int temperature;

    public Termostat(Protocol protocol, String name) {
        super(protocol, name, Device.Type.Termostat);
    }
    public void setTemperature(int temperature) {
            this.temperature = temperature;
    }
    public int getTemperature() {return temperature;}
    @Override
    public Termostat copy() {
        Termostat termostat = new Termostat(super.getProtocol(), super.name);
        termostat.temperature = this.temperature;

        return termostat;
    }
    @Override
    public boolean setProprety(String proprety, String value) {
        switch (proprety) {
            case "temperature" :
            try {int val = Integer.parseInt(value);
                if(val >= 10 && val <= 30) {
                this.temperature = val;
                return true;
                }    
            } catch(NumberFormatException e) {throw new InaccessibleObjectException("wrong value foramt inputed for proprety");}
            break;
            case "status" :
            if(value.equals("on")) {super.setStatus(Device.Status.ON); return true;}
            if(value.equals("off")) {super.setStatus(Device.Status.OFF); return true;}
            break;
        }
        return false;
    }
}
