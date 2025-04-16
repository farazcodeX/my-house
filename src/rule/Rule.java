package rule;

import java.sql.Date;
import java.sql.Time;

public class Rule {
    public final String deviceName;
    private Time time;
    private String action;
    public Rule(String name, Time time, String action) {
        this.deviceName = name;
        this.time = time;
        this.action = action;
    }
    public Time getTime() {return time;}
    public String getAction() {return action;}


}
