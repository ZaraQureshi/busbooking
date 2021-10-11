package com.example.busapplication;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.busapplication.Bus;

import java.util.ArrayList;

public class BusAdapter extends RecyclerView.Adapter<BusAdapter.ViewHolder>{

    // variable for our array list and context
    private ArrayList<Bus> busList;
    private Context context;

    // constructor
    public BusAdapter(ArrayList<Bus> busList, Context context) {
        this.busList = busList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout_bus, parent, false);
        Log.d("BusAdapter ","fine till onCreateViewHolder");

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        // on below line we are setting data 
        // to our views of recycler view item.
        Bus modal = busList.get(position);
        holder.busName.setText(modal.getName());
        holder.busSource.setText(modal.getSource());
        holder.busDest.setText(modal.getDestination());
        holder.busAmt.setText(modal.getAmount());
        holder.busDate.setText(modal.getDate());
//      holder.busImage.setText("image", modal.getImage());
        Log.d("BusAdapter ","fine till onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return busList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView busName,busSource,busDest,busAmt,busDate,busImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            busName = itemView.findViewById(R.id.busName);
            busAmt = itemView.findViewById(R.id.amt);
            busDate = itemView.findViewById(R.id.date);
            busSource = itemView.findViewById(R.id.busSource);
            busDest = itemView.findViewById(R.id.busDestination);
//            busImage = itemView.findViewById(R.id.busImage);

            Log.d("BusAdapter ","fine till ViewHolder");

        }
    }
}