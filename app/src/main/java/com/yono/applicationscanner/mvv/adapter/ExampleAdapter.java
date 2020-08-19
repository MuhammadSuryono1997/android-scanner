package com.yono.applicationscanner.mvv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.yono.applicationscanner.R;
import com.yono.applicationscanner.databinding.ItemLastUpdateDashboardBinding;
import com.yono.applicationscanner.mvv.response.ExampleResponse;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.MyViewHolder> {

    private ArrayList<ExampleResponse> exampleResponses;
    Context context;

    public ExampleAdapter(Context context, ArrayList<ExampleResponse> exampleResponses){
        this.exampleResponses = exampleResponses;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ExampleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLastUpdateDashboardBinding itemLastUpdateDashboardBinding
                = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_last_update_dashboard,
                parent,
                false
        );
        return new MyViewHolder(itemLastUpdateDashboardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleAdapter.MyViewHolder holder, int position) {
        holder.binData(exampleResponses.get(position));
    }

    @Override
    public int getItemCount() {
        return exampleResponses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemLastUpdateDashboardBinding binding;

        public MyViewHolder(@NonNull ItemLastUpdateDashboardBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void binData(ExampleResponse exampleResponse){
            binding.setLastupdate(exampleResponse);
            binding.setImages(exampleResponse.getImageExample());
        }
    }
}
