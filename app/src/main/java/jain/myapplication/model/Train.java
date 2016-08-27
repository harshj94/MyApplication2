package jain.myapplication.model;

/**
 * Created by harsh on 27-Aug-16.
 */
public class Train {
    private ClassType[] classes;

    private To to;

    private Days[] days;

    private String no;

    private String name;

    private String dest_arrival_time;

    private String number;

    private From from;

    private String src_departure_time;

    private String travel_time;

    public ClassType[] getClasses() {
        return classes;
    }

    public void setClasses(ClassType[] classes) {
        this.classes = classes;
    }

    public To getTo() {
        return to;
    }

    public void setTo(To to) {
        this.to = to;
    }

    public Days[] getDays() {
        return days;
    }

    public void setDays(Days[] days) {
        this.days = days;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDest_arrival_time() {
        return dest_arrival_time;
    }

    public void setDest_arrival_time(String dest_arrival_time) {
        this.dest_arrival_time = dest_arrival_time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public String getSrc_departure_time() {
        return src_departure_time;
    }

    public void setSrc_departure_time(String src_departure_time) {
        this.src_departure_time = src_departure_time;
    }

    public String getTravel_time() {
        return travel_time;
    }

    public void setTravel_time(String travel_time) {
        this.travel_time = travel_time;
    }

    @Override
    public String toString() {
        return "ClassPojo [classes = " + classes + ", to = " + to + ", days = " + days + ", no = " + no + ", name = " + name + ", dest_arrival_time = " + dest_arrival_time + ", number = " + number + ", from = " + from + ", src_departure_time = " + src_departure_time + ", travel_time = " + travel_time + "]";
    }
}
