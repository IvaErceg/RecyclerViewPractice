package com.example.android.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Iva on 19.2.2017..
 */


public class NameAdapter extends RecyclerView.Adapter<NameAdapter.ViewHolder> {
    private ArrayList<String> names;
    private OnItemClickListener mOnClickListener;

    public NameAdapter(ArrayList<String> names, OnItemClickListener listener) {
        this.names = names;
        this.mOnClickListener = listener;
    }
     interface OnItemClickListener{
         void onItemClick(int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mNameTextView = (TextView) itemView.findViewById(R.id.tw_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            mOnClickListener.onItemClick(position);
        }
    }
    @Override
    public NameAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_names, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String name = names.get(position);
        holder.mNameTextView.setText(name);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }
}



