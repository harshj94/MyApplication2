package jain.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import jain.myapplication.model.Train;
import jain.myapplication.model.TrainBetweenStations;
import jain.myapplication.rest.ApiClient;
import jain.myapplication.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainListActivity extends AppCompatActivity {

    private static final String TAG = "RecyclerViewExample";
    private List<Train> trainList;
    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_list_acitivity);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<TrainBetweenStations> call2 = apiService.getTrainBetweenStations(getIntent().getStringExtra("Source"), getIntent().getStringExtra("Destination"), getIntent().getStringExtra("Date"));
        call2.enqueue(new Callback<TrainBetweenStations>() {

            @Override
            public void onResponse(Call<TrainBetweenStations> call, Response<TrainBetweenStations> response) {
                progressBar.setVisibility(View.GONE);
                if (response.body().getResponse_code().equals("200")) {
                    Train[] trains = response.body().getTrain();
                    trainList = Arrays.asList(trains);
                    adapter = new MyRecyclerAdapter(TrainListActivity.this, trainList);
                    mRecyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(TrainListActivity.this, "Failed to fetch data!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TrainBetweenStations> call, Throwable t) {
                Toast.makeText(TrainListActivity.this, "Failed to fetch data!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
