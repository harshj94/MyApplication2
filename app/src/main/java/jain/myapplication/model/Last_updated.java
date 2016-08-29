package jain.myapplication.model;

/**
 * Created by harsh on 12-Aug-16.
 */
public class Last_updated {
    private String time;

    private String date;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ClassPojo [time = " + time + ", date = " + date + "]";
    }
}
