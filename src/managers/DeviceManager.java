package managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import devices.Device;
import devices.Light;
import devices.Termostat;
import exceptions.DeviceNotFoundExceprion;
import exceptions.InvalidInputException;
import validators.DeviceValidator;

public class DeviceManager {
    // store + some methods 
    private static HashMap<String, Device> devices = new HashMap<>();
    private static DeviceValidator deviceValidator = new DeviceValidator();

    public static List<String> protocols = List.of("bluetooth", "wifi");
    //public static List<String> types = List.of("light", "termostat");

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

       Device device = null;
       switch (typeInput) {
          case "light" : device = new Light(convertProtocol(protocolInput), name); break;
          case "thermostat" : device = new Termostat(convertProtocol(protocolInput), name); break;
          default : throw new InvalidInputException("Invalid type : type " + typeInput + " is not registerd"); 
       }
       devices.put(name, device.copy());
    }
    private static Device.Type convertType(String typeInput) {
        return Arrays.stream(Device.Type.values()).filter(type -> type.name().equals(typeInput)).findFirst().orElse(null);
    }

    public static void setDevice(String name, String proprety, String value) {

        Device device = devices.get(name);
        if(device == null) {throw new InvalidInputException("Device name " + name + " not found");}

        // input propreties to lowe case
        if(device.setProprety(proprety, value)) {
            System.out.println("device updated successfully");
        } else {
            throw new InvalidInputException("Something went wrong");
        }
    }

    private static Device.Protocol convertProtocol(String proInput) {
        return Arrays.stream(Device.Protocol.values()).filter(pro -> pro.name().equals(proInput)).findAny().orElse(null);
    }

    public static void removeDevice(String name) {
        if(devices.containsKey(name)) {
            devices.remove(name);
        } else {
            throw new InvalidInputException("Device : " + name + " not found");
        }
    }
    public static void listDevice() {
        if(devices.isEmpty()) {
            System.out.println("No device added");
        } else {
            for (Device device : devices.values()) {
                if (device.type == Device.Type.Light) {
                    Light light = (Light) device;
                    System.out.println("Light : " + light.name +
                        " status : " + light.getStatus().name() +
                        " brightness : " + light.getBrightnes());
                } else if (device.type == Device.Type.Termostat) {
                    Termostat termostat = (Termostat) device;
                    System.out.println("Termostat : " + termostat.name +
                        " status : " + termostat.getStatus().name() +
                        " Temperature : " + termostat.getTemperature());
                }
            }
        }
    }
    public static void update(Device device) {
        if(devices.containsKey(device.name)) {
            devices.replace(device.name, device.copy());
        } else {
            throw new InvalidInputException("Device : " + device.name + " Not found");
        }
    }


}
