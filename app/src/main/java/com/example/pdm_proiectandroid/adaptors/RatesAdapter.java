package com.example.pdm_proiectandroid.adaptors;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pdm_proiectandroid.R;
import com.example.pdm_proiectandroid.entities.Rate;

import java.util.ArrayList;

import static com.example.pdm_proiectandroid.MainActivity.SelectedCurrency;

public class RatesAdapter extends RecyclerView.Adapter<RatesAdapter.ViewHolder> {

    ArrayList<Rate> rateList = new ArrayList<>();

    public RatesAdapter(ArrayList<Rate> rateList){
        this.rateList = rateList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_rate, viewGroup, false);

        return new RatesAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RatesAdapter.ViewHolder viewHolder, int i) {
        Rate rate = rateList.get(i);
        viewHolder.rate_name.setText(rate.getName());
        viewHolder.rate_value.setText(rate.getValue() + " " + SelectedCurrency.getName());
    }

    @Override
    public int getItemCount() {
        return rateList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView rate_name, rate_value;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rate_name = itemView.findViewById(R.id.rate_name);
            rate_value = itemView.findViewById(R.id.rate_value);
        }


    }
}
