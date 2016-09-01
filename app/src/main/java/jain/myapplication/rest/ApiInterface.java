package jain.myapplication.rest;

import jain.myapplication.model.TrainAvailability;
import jain.myapplication.model.TrainBetweenStations;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("check_seat/train/{train_number}/source/{source}/dest/{destination}/date/{date}/class/{classtype}/quota/{quota}/apikey/vdtqp7326")
    Call<TrainAvailability> getAvailabilityDetails(@Path("train_number") String train_number,
                                                   @Path("source") String source,
                                                   @Path("destination") String destination,
                                                   @Path("date") String date,
                                                   @Path("classtype") String classtype,
                                                   @Path("quota") String quota);

    @GET("between/source/{source}/dest/{destination}/date/{date}/apikey/hheew2892")
    Call<TrainBetweenStations> getTrainBetweenStations(@Path("source") String source,
                                                       @Path("destination") String destination,
                                                       @Path("date") String date);
}
