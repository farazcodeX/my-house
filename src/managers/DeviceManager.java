package managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import devices.Device;
import exceptions.DeviceNotFoundExceprion;
import exceptions.InvalidInputException;
import validators.DeviceValidator;

public class DeviceManager {
    // store + some methods 
    private static HashMap<String, Device> devices = new HashMap<>();
    private static DeviceValidator deviceValidator = new DeviceValidator();

    private static List<String> protocols = List.of("bluetooth", "wifi");
    private static List<String> types = List.of("light", "termostat");

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
       if(devices.containsKey(name) || name.isEmpty()) {
          throw new InvalidInputException("Device Name : " + name + " is already exist OR name is empty");
       }
       if(!protocols.contains(protocolInput)) {
          throw new InvalidInputException("Invalid protocol");
       }
       if(!types.contains(typeInput)) {
          throw new InvalidInputException("Invalid type input");
       }

       Device device = new Device(convertProtocol(protocolInput), name, convertType(typeInput));

       devices.put(name, device);
    }
    private static Device.Type convertType(String typeInput) {
        return Arrays.stream(Device.Type.values()).filter(type -> type.name().equals(typeInput)).findFirst().orElse(null);
    }

    public static void setDevice(String name, String proprety, String value) {
        
    }


    private static Device.Protocol convertProtocol(String proInput) {
        return Arrays.stream(Device.Protocol.values()).filter(pro -> pro.name().equals(proInput)).findAny().orElse(null);
    }
    public static void updateDevice(Device device) {
        // replace the givne device with old device with same key
    }
    
    
    

    



}
