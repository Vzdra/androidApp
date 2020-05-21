package com.example.myappproject.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myappproject.Helpers.Types;
import com.example.myappproject.Networking.ResponseStructures.City;
import com.example.myappproject.Networking.ResponseStructures.Country;
import com.example.myappproject.Networking.ResponseStructures.State;
import com.example.myappproject.R;

import java.util.List;

public class RecyclerViewAdapter<T> extends RecyclerView.Adapter<CustomViewHolder> {

    private List<T> dataList;
    private LayoutInflater inflater;
    private Context context;
    private Types type;
    private String country = null;
    private String state = null;
    private String city = null;

    public RecyclerViewAdapter(List<T> dataList, Context context, Types type){
        this.dataList = dataList;
        this.context = context;
        this.type = type;
    }

    public RecyclerViewAdapter(List<T> dataList, Context context, Types type, String country){
        this.dataList = dataList;
        this.context = context;
        this.type = type;
        this.country = country;
    }

    public RecyclerViewAdapter(List<T> dataList, Context context, Types type, String country, String state){
        this.dataList = dataList;
        this.context = context;
        this.type = type;
        this.country = country;
        this.state = state;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.listview, parent, false);

        if(country!=null && state!=null && city!=null){
            return new CustomViewHolder(view, context, dataList, type, country, state, city);
        }else if(country!=null && state!=null) {
            return new CustomViewHolder(view, context, dataList, type, country, state);
        }else if(country!=null){
            return new CustomViewHolder(view, context, dataList, type, country);
        }

        return new CustomViewHolder(view, context, dataList, type);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        if(type == Types.COUNTRY){
            holder.getTextView().setText(((Country)dataList.get(position)).getCountry());
        }else if(type == Types.STATE) {
            holder.getTextView().setText((((State)dataList.get(position)).getState()));
        }else if (type == Types.CITY){
            holder.getTextView().setText((((City)dataList.get(position)).getCity()));
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
