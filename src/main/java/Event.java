import org.apache.commons.lang.RandomStringUtils;

import java.text.DateFormat;
import java.util.Date;

public class Event {
    int id = Integer.parseInt(RandomStringUtils.random(7, false, true));
    String msg;
    Date date;
    DateFormat df;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Event(String msg, Date date, DateFormat df) {
        this.date = date;
        this.msg = msg;
        this.df = df;
    }

    @Override
    public String toString() {
        return "Message: " + this.msg + ", Date: " + df.format(this.date) + ", ID: " + this.id;
    }
}
