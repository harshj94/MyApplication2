package jain.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import jain.myapplication.model.Train;

/**
 * Created by harsh on 29-Aug-16.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.CustomViewHolder> {

    private List<Train> trainList;
    private Context mContext;

    public MyRecyclerAdapter(Context context, List<Train> feedItemList) {
        this.trainList = feedItemList;
        this.mContext = context;
    }

    @Override
    public MyRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerAdapter.CustomViewHolder holder, int position) {
        final Train train = trainList.get(position);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomViewHolder holder = (CustomViewHolder) view.getTag();
                int position = holder.getPosition();
                Train feedItem = trainList.get(position);
                Toast.makeText(mContext, feedItem.getName(), Toast.LENGTH_SHORT).show();
            }
        };
        holder.trainNumber.setOnClickListener(clickListener);

        holder.trainNumber.setTag(holder);
        holder.trainNumber.setText(train.getNumber());
        holder.trainName.setText(train.getName());
        holder.from.setText(train.getFrom().getCode());
        holder.to.setText(train.getTo().getCode());
        holder.srcTime.setText(train.getSrc_departure_time());
        holder.destTime.setText(train.getDest_arrival_time());
    }

    @Override
    public int getItemCount() {
        return (null != trainList ? trainList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView trainNumber, trainName, from, srcTime, to, destTime;

        public CustomViewHolder(View view) {
            super(view);
            this.trainNumber = (TextView) view.findViewById(R.id.trainNumber);
            this.trainName = (TextView) view.findViewById(R.id.trainName);
            this.from = (TextView) view.findViewById(R.id.from);
            this.srcTime = (TextView) view.findViewById(R.id.sourceTime);
            this.to = (TextView) view.findViewById(R.id.to);
            this.destTime = (TextView) view.findViewById(R.id.destTime);
        }
    }
}
