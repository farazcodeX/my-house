package devices;

public class Light extends Device{
    
    private int brightnes = 50;

    public Light(Protocol protocol, String name) {
        super(protocol, name, Device.Type.LIGHT);
        
    }
    private void setBrightness(int brightnes) {
        this.brightnes = brightnes;
    }
    
}
