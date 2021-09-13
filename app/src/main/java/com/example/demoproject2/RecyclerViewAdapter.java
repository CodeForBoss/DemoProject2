package com.example.demoproject2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private List<SeatModelList> allSeats;

    public RecyclerViewAdapter(List<SeatModelList> allSeats) {
        this.allSeats = allSeats;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view,null);
        MyViewHolder myViewHolder = new MyViewHolder(layoutView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        SeatModelList seatModelList = allSeats.get(i);
        List<SeatModel> seatModels = seatModelList.getAllSeatModels();
        if(i == 0) {
            myViewHolder.t1.setText(seatModels.get(0).getT());
            myViewHolder.t4.setText(seatModels.get(4).getT());
        } else if(i==allSeats.size()-1){
            myViewHolder.t1.setText(seatModels.get(0).getN());
            myViewHolder.t2.setText(seatModels.get(1).getN());
            myViewHolder.t5.setText(seatModels.get(2).getN());
            myViewHolder.t3.setText(seatModels.get(3).getN());
            myViewHolder.t4.setText(seatModels.get(4).getN());
            myViewHolder.t5.setBackgroundResource(R.drawable.box0);
        }
        else {
            myViewHolder.t1.setText(seatModels.get(0).getN());
            myViewHolder.t2.setText(seatModels.get(1).getN());
            myViewHolder.t3.setText(seatModels.get(2).getN());
            myViewHolder.t4.setText(seatModels.get(3).getN());
        }
    }

    @Override
    public int getItemCount() {
        return allSeats.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView t1,t2,t3,t4,t5;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.zeroTv);
            t2 = itemView.findViewById(R.id.oneTv);
            t3 = itemView.findViewById(R.id.threeTv);
            t4 = itemView.findViewById(R.id.fourTv);
            t5 = itemView.findViewById(R.id.middleTv);
        }
    }
}
