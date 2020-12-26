package com.example.note;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdaptor extends RecyclerView.Adapter<RecycleAdaptor.ViewHolder> {
    List<androidmodeldata> DataSet = new ArrayList<>();

    public RecycleAdaptor(List<androidmodeldata> localDataSet) {
        this.DataSet = localDataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_row_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        androidmodeldata text = DataSet.get(position);
        holder.textView.setText(text.getText());
    }

    @Override
    public int getItemCount() {
        return DataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textView);
        }

    }
}
