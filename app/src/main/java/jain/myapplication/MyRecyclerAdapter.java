package jain.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.silencedut.expandablelayout.ExpandableLayout;

import java.util.List;

import jain.myapplication.model.ClassType;
import jain.myapplication.model.Train;

/**
 * Created by harsh on 29-Aug-16.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.CustomViewHolder> {

    ClassType[] classTypes;
    MyRecyclerAdapter.CustomViewHolder holder;
    private List<Train> trainList;
    private Context mContext;

    public MyRecyclerAdapter(Context context, List<Train> feedItemList) {
        this.trainList = feedItemList;
        this.mContext = context;
    }

    @Override
    public MyRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, null);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyRecyclerAdapter.CustomViewHolder holder, int position) {
        this.holder = holder;
        final Train train = trainList.get(position);

        holder.expandableLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.imageView.getTag().toString().equals("down")) {
                    holder.imageView.setImageResource(R.drawable.uparrow);
                    holder.imageView.setTag("up");
                } else {
                    holder.imageView.setImageResource(R.drawable.downarrow);
                    holder.imageView.setTag("down");
                }
            }
        });

        holder.trainNumber.setText(train.getNumber());
        holder.trainName.setText(train.getName());
        holder.from.setText(train.getFrom().getCode());
        holder.to.setText(train.getTo().getCode());
        holder.srcTime.setText(train.getSrc_departure_time());
        holder.destTime.setText(train.getDest_arrival_time());
        classTypes = train.getClasses();
        for (ClassType classType : classTypes) {
            if (classType.getClass_code().equals("1A") && classType.getAvailable().equals("N")) {
                holder.availableClasses.removeView(holder.firstac);
            }
            if (classType.getClass_code().equals("2A") && classType.getAvailable().equals("N")) {
                holder.availableClasses.removeView(holder.secondac);
            }
            if (classType.getClass_code().equals("3A") && classType.getAvailable().equals("N")) {
                holder.availableClasses.removeView(holder.thirdac);
            }
            if (classType.getClass_code().equals("SL") && classType.getAvailable().equals("N")) {
                holder.availableClasses.removeView(holder.sleeper);
            }
            if (classType.getClass_code().equals("2S") && classType.getAvailable().equals("N")) {
                holder.availableClasses.removeView(holder.secondseating);
            }
            if (classType.getClass_code().equals("CC") && classType.getAvailable().equals("N")) {
                holder.availableClasses.removeView(holder.chaircar);
            }
        }
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return (null != trainList ? trainList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView trainNumber, trainName, from, srcTime, to, destTime, firstac, secondac, thirdac, sleeper, secondseating, chaircar;
        protected ExpandableLayout expandableLayout;
        protected ImageView imageView;
        protected LinearLayout availableClasses;

        public CustomViewHolder(View view) {
            super(view);
            this.trainNumber = (TextView) view.findViewById(R.id.trainNumber);
            this.expandableLayout = (ExpandableLayout) view.findViewById(R.id.expand);
            this.trainName = (TextView) view.findViewById(R.id.trainName);
            this.from = (TextView) view.findViewById(R.id.from);
            this.srcTime = (TextView) view.findViewById(R.id.sourceTime);
            this.to = (TextView) view.findViewById(R.id.to);
            this.destTime = (TextView) view.findViewById(R.id.destTime);
            this.imageView = (ImageView) view.findViewById(R.id.arrow);
            this.availableClasses = (LinearLayout) view.findViewById(R.id.availableClasses);
            this.firstac = (TextView) view.findViewById(R.id.firstac);
            this.secondac = (TextView) view.findViewById(R.id.secondac);
            this.thirdac = (TextView) view.findViewById(R.id.thirdac);
            this.sleeper = (TextView) view.findViewById(R.id.sleeper);
            this.secondseating = (TextView) view.findViewById(R.id.secondseating);
            this.chaircar = (TextView) view.findViewById(R.id.chaircar);
        }
    }
}
