package rule;

import java.sql.Date;
import java.sql.Time;

public class Rule {
    public final String deviceName;
    private String time;
    private String action;
    public Rule(String name, String time, String action) {
        this.deviceName = name;
        this.time = time;
        this.action = action;
    }
    public String getTime() {return time;}
    public String getAction() {return action;}
    public String getName() {return deviceName;}


}
