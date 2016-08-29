package jain.myapplication.model;

/**
 * Created by harsh on 12-Aug-16.
 */
public class Quota {
    private String quota_code;

    private String quota_name;

    public String getQuota_code() {
        return quota_code;
    }

    public void setQuota_code(String quota_code) {
        this.quota_code = quota_code;
    }

    public String getQuota_name() {
        return quota_name;
    }

    public void setQuota_name(String quota_name) {
        this.quota_name = quota_name;
    }

    @Override
    public String toString() {
        return "ClassPojo [quota_code = " + quota_code + ", quota_name = " + quota_name + "]";
    }
}