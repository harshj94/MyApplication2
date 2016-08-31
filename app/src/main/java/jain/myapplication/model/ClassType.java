package jain.myapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by harsh on 12-Aug-16.
 */
public class ClassType {
    @SerializedName(value = "class-code")
    private String class_code;
    private String class_name;
    private String available;


    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "ClassPojo [class_code = " + class_code + ", class_name = " + class_name + "]";
    }
}
