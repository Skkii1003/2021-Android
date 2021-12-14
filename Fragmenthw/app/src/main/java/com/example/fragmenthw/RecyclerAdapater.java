package com.example.fragmenthw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class RecyclerAdapater extends RecyclerView.Adapter<RecyclerAdapater.LinearViewHolder> {

    private Context context;

    public RecyclerAdapater(Context context) {
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull LinearViewHolder holder, int position) {
        holder.textView.setText("hello!!!");
    }


    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;

        public LinearViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item);
        }
    }
}
