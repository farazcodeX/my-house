package exceptions;

public class DeviceNotFoundExceprion extends RuntimeException{
    public DeviceNotFoundExceprion() {
        super();
    }
    public DeviceNotFoundExceprion(String massage) {
        super(massage);
    }
    
}
