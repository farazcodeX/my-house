package managers;

import java.sql.Time;
import java.util.ArrayList;

import exceptions.DeviceNotFoundExceprion;
import rule.Rule;

public final class RuleManager {
    private ArrayList<Rule> rules = new ArrayList<>();

    private RuleManager() {}

    public void addRule(String name, Time time, String action) {
        DeviceManager.getDevice(name);

        // if not throwed exception :
        Rule rule = new Rule(name, time, action);
        rules.add(rule);
    }
    


}
