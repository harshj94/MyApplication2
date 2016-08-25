package jain.myapplication.model;

import java.util.Arrays;

public class TrainAvailability {
    private To to;

    private String train_name;

    private Quota quota;

    private String error;

    private String failure_rate;

    private String response_code;

    private String train_number;

    private ClassType classType;

    private Last_updated last_updated;

    private From from;

    private Availability[] availability;

    public To getTo() {
        return to;
    }

    public void setTo(To to) {
        this.to = to;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public Quota getQuota() {
        return quota;
    }

    public void setQuota(Quota quota) {
        this.quota = quota;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getFailure_rate() {
        return failure_rate;
    }

    public void setFailure_rate(String failure_rate) {
        this.failure_rate = failure_rate;
    }

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public String getTrain_number() {
        return train_number;
    }

    public void setTrain_number(String train_number) {
        this.train_number = train_number;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClasss(ClassType classType) {
        this.classType = classType;
    }

    public Last_updated getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Last_updated last_updated) {
        this.last_updated = last_updated;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public Availability[] getAvailability() {
        return availability;
    }

    public void setAvailability(Availability[] availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "ClassPojo [to = " + to + ", train_name = " + train_name + ", quota = " + quota + ", error = " + error + ", failure_rate = " + failure_rate + ", response_code = " + response_code + ", train_number = " + train_number + ", class = " +
                classType + ", last_updated = " + last_updated + ", from = " + from + ", availability = " + Arrays.toString(availability) + "]";
    }
}