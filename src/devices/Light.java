package devices;

public class Light extends Device{
    
    private int brightnes = 50;

    public Light(Protocol protocol, String name) {
        super(protocol, name, Device.Type.LIGHT);
        
    }
    public void setBrightness(int brightnes) {
        this.brightnes = brightnes;
    }
    public int getBrightness() {return brightnes;}
}
