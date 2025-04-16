package managers;

import java.util.Arrays;
import java.util.HashMap;

import devices.Device;
import exceptions.DeviceNotFoundExceprion;
import exceptions.InvalidInputException;

public class DeviceManager {
    // store + some methods 
    private static HashMap<String, Device> devices = new HashMap<>();

    private DeviceManager() {}

    public static Device getDevice(String name) {
        if(devices.containsKey(name)) {
            Device device = devices.get(name);
            return device.copy();
        } else {
            throw new DeviceNotFoundExceprion("Device : " + name + "  Not added");
        }
    }
    public static void addDevice(String name, String protocolInput, String typeInput) {
       if(devices.containsKey(name)) {
          throw new InvalidInputException("Device Name : " + name + " is already exist");
       }
       // this is mine
       // just remember when you scaning : scan touppercase
       if(Arrays.stream(Device.Type.values()).anyMatch(type -> type.name().equalsIgnoreCase(typeInput))) {
           throw new InvalidInputException("Devise Type : " + typeInput + " is not Available");
        } 
        if(Arrays.stream(Device.Protocol.values()).anyMatch(protocol -> protocol.name().equalsIgnoreCase(protocolInput))) {
            throw new InvalidInputException("Inputed Protocol : " + protocolInput + " is not Valid");
        }

        

    }
    



}
