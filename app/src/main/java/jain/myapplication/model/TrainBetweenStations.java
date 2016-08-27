package jain.myapplication.model;

/**
 * Created by harsh on 27-Aug-16.
 */
public class TrainBetweenStations {
    private String total;

    private String error;

    private String response_code;

    private Train[] train;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public Train[] getTrain() {
        return train;
    }

    public void setTrain(Train[] train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return "ClassPojo [total = " + total + ", error = " + error + ", response_code = " + response_code + ", train = " + train + "]";
    }
}
