package jain.myapplication.model;

/**
 * Created by harsh on 12-Aug-16.
 */
public class To {
    private String name;

    private String lng;

    private String code;

    private String lat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "ClassPojo [name = " + name + ", lng = " + lng + ", code = " + code + ", lat = " + lat + "]";
    }
}
