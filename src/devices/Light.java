package devices;

import java.lang.reflect.InaccessibleObjectException;

import exceptions.InvalidInputException;

public class Light extends Device{
    
    private int brightnes = 0;

    public Light(Protocol protocol, String name) {
        super(protocol, name, Device.Type.Light);
        
    }
    public void setBrightness(int brightnes) {
        this.brightnes = brightnes;
    }
    public int getBrightnes() {
        if(getStatus() == Device.Status.OFF) {return 0;}
        
        return brightnes;
    }

    @Override
    public Light copy() {
        Light light = new Light(super.getProtocol(), super.name);
        light.brightnes = brightnes;

        return light;
    }
    @Override
    public boolean setProprety(String proprety, String value) {
        switch (proprety) {
            case "brightness" : 
            try {
               int val = Integer.parseInt(value);
               if(val >= 0 && val <= 100) {
                this.brightnes = val;
                return true;
                }                
            } catch (NumberFormatException e) {throw new InvalidInputException("WRONG format inputed");}
            break;
            case "status" :
            if(value.equalsIgnoreCase("on")) {super.setStatus(Device.Status.ON); return true;}
            if(value.equalsIgnoreCase("off")) {super.setStatus(Device.Status.OFF); return true;}
            break;
        }
        return false;
    }


}
