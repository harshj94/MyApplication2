package jain.myapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by harsh on 27_Aug_16.
 */
public class Days {
    @SerializedName(value = "day-code")
    private String day_code;

    private String runs;

    public String getDay_code() {
        return day_code;
    }

    public void setDay_code(String day_code) {
        this.day_code = day_code;
    }

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

    @Override
    public String toString() {
        return "ClassPojo [day_code = " + day_code + ", runs = " + runs + "]";
    }
}
