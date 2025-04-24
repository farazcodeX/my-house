package UI;

import java.util.List;
import java.util.Scanner;

import exceptions.DeviceNotFoundExceprion;
import exceptions.InvalidInputException;
import managers.DeviceManager;
import managers.RuleManager;
import rule.Rule;

public class UI {
    private static Scanner scanner = new Scanner(System.in);
    public static void getInput() {
        int numbers = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i <= numbers; ++i) {
            String input = scanner.nextLine().trim().toLowerCase();
            String[] split = input.split(" ");
            switch (split[0]) {
                case "add_device" : addDevice(split); break;
                case "set_device" : setDevice(split); break;
                case "add_rule" : addRule(split); break;
                case "remove_device" : remove_device(split); break;
                case "list_devices" : list_devices(); break;
                case "check_rules" : check_rules(split); break;
                case "list_rules" : list_rules(); break;
                default : System.out.println("wrong input");
            }
        }
    }
    public static void addDevice(String[] splits) {
      //  System.out.println(splits[0] + "  " + splits[1] + "  " + "  " + splits[2] + " " + splits[3]);
        System.out.println("-------------------");
        try {
            DeviceManager.addDevice(splits[2], splits[3], splits[1]);
            System.out.println("device added successfully");
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void setDevice(String[] splits) {
        System.out.println("----------------------");
        try {
            DeviceManager.setDevice(splits[1], splits[2], splits[3]);
            System.out.println("device updated successfully");
        } catch (DeviceNotFoundExceprion | InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void addRule(String[] split) {
        System.out.println("-------------------");
        try {
            RuleManager.addRule(split[1], split[2], split[3]);
            System.out.println("rule added successfully");
        } catch (InvalidInputException | DeviceNotFoundExceprion e) {
            System.out.println(e.getMessage());
        }
    }
    public static void remove_device(String[] split) {
        System.out.println("----------------------");
        try {
            DeviceManager.removeDevice(split[1]);
            System.out.println("device removed successfully");
        } catch (DeviceNotFoundExceprion e) {
            System.out.println(e.getMessage());
        }
    }
    public static void list_devices() {
        System.out.println("---------------------");
        DeviceManager.listDevice();
    }
    public static void list_rules() {
        System.out.println("-------------------------");
        RuleManager.listRules();
    } 
    public static void check_rules(String[] split) {
        System.out.println("----------------------");
        try {
            RuleManager.checkRule(split[1]);
            System.out.println("rules checked");
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
