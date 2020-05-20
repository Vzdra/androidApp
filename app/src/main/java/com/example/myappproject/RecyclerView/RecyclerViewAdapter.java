package com.example.myappproject.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myappproject.Networking.ResponseStructures.Country;
import com.example.myappproject.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<CountryViewHolder> {

    private List<Country> dataList;
    private LayoutInflater inflater;
    private Context context;

    public RecyclerViewAdapter(List<Country> dataList, Context context){
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.listview, parent, false);
        return new CountryViewHolder(view, context, dataList);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.getTextView().setText(dataList.get(position).getCountry());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
