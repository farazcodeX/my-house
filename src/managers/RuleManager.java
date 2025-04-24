package managers;

import java.security.InvalidAlgorithmParameterException;
import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import exceptions.DeviceNotFoundExceprion;
import exceptions.InvalidInputException;
import rule.Rule;
import devices.Device;

public final class RuleManager {
    private static ArrayList<Rule> rules = new ArrayList<>();

    private RuleManager() {}

    public static void addRule(String name, String time, String action) {
        // if device not exists : exc
        DeviceManager.getDevice(name);

        // if not throwed exception :
        Rule rule = new Rule(name, time, action);
        rules.add(rule);
    }
    public static void checkRule(String time) {
        // 
        if (!time.matches("([01]\\d|2[0-3]):[0-5]\\d")) {
            throw new InvalidInputException("Invalid format: time must be in HH:mm format");
        }
        

        rules.stream().filter(rule -> rule.getTime().equals(time)).map(rule -> {
            Device device = DeviceManager.getDevice(rule.getName());
            if(rule.getAction().equalsIgnoreCase("on")) {
                device.setStatus(Device.Status.ON);
            } 
            else if(rule.getAction().equalsIgnoreCase("off")) {
                device.setStatus(Device.Status.OFF);
            }
            DeviceManager.update(device);
            return null;
        }).toList();
    }
    public static void listRules() {
        if(rules.isEmpty()) {
            throw new InvalidInputException("No Rules");
        }

        rules.stream().forEach(rule -> {
            System.out.println("Rule " + rule.getName() + " Time : " + rule.getTime() + " Action : setDevice" + rule.getAction() );
        });
    }
    
    


}
