package com.example.snowyleung.oven_fresh.Schedule;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.snowyleung.oven_fresh.R;

import java.util.ArrayList;

/**
 * Created by SnowyLeung on 18/4/2017.
 */

public class BreadAdapter extends RecyclerView.Adapter<BreadAdapter.ViewHolder>{

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bread bread = list.get(position);
        holder.setValues(bread);
    }

    @Override
    public int getItemCount() {
        return list==null ? 0 : list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        final TextView textViewName;
        final TextView textViewTime;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.Name);
            textViewTime = (TextView) itemView.findViewById(R.id.Time);
        }

        public void setValues(Bread bread){
            textViewName.setText(bread.getName());
            textViewTime.setText(bread.getTime());
        }
    }

    final ArrayList<Bread> list;

    public BreadAdapter(ArrayList<Bread> list) {
        this.list = list;
    }
}