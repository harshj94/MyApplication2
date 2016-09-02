package jain.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
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
        final Train train = trainList.get(position);

        holder.trainNumber.setText(train.getNumber());
        holder.trainName.setText(train.getName());
        holder.from.setText(train.getFrom().getCode());
        holder.to.setText(train.getTo().getCode());
        holder.srcTime.setText(train.getSrc_departure_time());
        holder.destTime.setText(train.getDest_arrival_time());
        classTypes = train.getClasses();
        holder.firstac.setVisibility(View.VISIBLE);
        holder.secondac.setVisibility(View.VISIBLE);
        holder.thirdac.setVisibility(View.VISIBLE);
        holder.sleeper.setVisibility(View.VISIBLE);
        holder.secondseating.setVisibility(View.VISIBLE);
        holder.chaircar.setVisibility(View.VISIBLE);

        for (ClassType classType : classTypes) {
            switch (classType.getClass_code()) {
                case "1A":
                    if (!classType.getAvailable().equals("Y"))
                        holder.firstac.setVisibility(View.GONE);
                    break;
                case "2A":
                    if (!classType.getAvailable().equals("Y"))
                        holder.secondac.setVisibility(View.GONE);
                    break;
                case "3A":
                    if (!classType.getAvailable().equals("Y"))
                        holder.thirdac.setVisibility(View.GONE);
                    break;
                case "SL":
                    if (!classType.getAvailable().equals("Y"))
                        holder.sleeper.setVisibility(View.GONE);
                    break;
                case "2S":
                    if (!classType.getAvailable().equals("Y"))
                        holder.secondseating.setVisibility(View.GONE);
                    break;
                case "CC":
                    if (!classType.getAvailable().equals("Y"))
                        holder.chaircar.setVisibility(View.GONE);
                    break;
            }
        }
        int lastPosition = -1;
        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        holder.itemView.startAnimation(animation);
    }

    @Override
    public void onViewDetachedFromWindow(CustomViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

    @Override
    public int getItemCount() {
        return (null != trainList ? trainList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView trainNumber, trainName, from, srcTime, to, destTime, firstac, secondac, thirdac, sleeper, secondseating, chaircar, availability;
        protected ExpandableLayout expandableLayout;
        protected ImageView imageView;
        protected View previousView = null;

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
            this.firstac = (TextView) view.findViewById(R.id.firstac);
            this.secondac = (TextView) view.findViewById(R.id.secondac);
            this.thirdac = (TextView) view.findViewById(R.id.thirdac);
            this.sleeper = (TextView) view.findViewById(R.id.sleeper);
            this.secondseating = (TextView) view.findViewById(R.id.secondseating);
            this.chaircar = (TextView) view.findViewById(R.id.chaircar);
            this.availability = (TextView) view.findViewById(R.id.availability);
            expandableLayout.setEnabled(false);

            firstac.setOnClickListener(this);
            secondac.setOnClickListener(this);
            thirdac.setOnClickListener(this);
            sleeper.setOnClickListener(this);
            chaircar.setOnClickListener(this);
            secondseating.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            view.setBackgroundResource(R.drawable.bg_blue);
            if (previousView == null || view == previousView) {
                if (expandableLayout.isExpanded()) {
                    expandableLayout.close();
                    view.setBackgroundResource(R.drawable.bg_red);
                } else {
                    expandableLayout.expand();
                }
            }
            if (previousView != null && view != previousView) {
                previousView.setBackgroundResource(R.drawable.bg_red);
                if (!expandableLayout.isExpanded()) {
                    expandableLayout.expand();
                }
            }
            previousView = view;
            switch (view.getId()) {
                case R.id.firstac:
                    availability.setText("availability for first ac");
                    break;
                case R.id.secondac:
                    availability.setText("availability for second ac");
                    break;
                case R.id.thirdac:
                    availability.setText("availability for third ac");
                    break;
                case R.id.sleeper:
                    availability.setText("availability for sleeper");
                    break;
                case R.id.chaircar:
                    availability.setText("availability for chair car");
                    break;
                case R.id.secondseating:
                    availability.setText("availability for second seating");
                    break;
                default:
                    availability.setText("Unable to fetch");
                    break;
            }
        }
    }
}
