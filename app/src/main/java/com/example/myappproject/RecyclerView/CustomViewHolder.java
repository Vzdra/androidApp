package com.example.myappproject.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myappproject.Activity.SearchActivity;
import com.example.myappproject.Helpers.Types;
import com.example.myappproject.Networking.ResponseStructures.City;
import com.example.myappproject.Networking.ResponseStructures.Country;
import com.example.myappproject.Networking.ResponseStructures.State;
import com.example.myappproject.R;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class CustomViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Context context;
    private List<T> data;
    private Types type;
    String country = null;
    String state = null;
    String city = null;

    private TextView textView;

    CustomViewHolder(View itemView, Context context, List<T> data, Types type){
        super(itemView);
        itemView.setOnClickListener(this);

        this.context = context;
        this.data = data;
        this.type = type;

        this.textView = itemView.findViewById(R.id.item_name);
    }

    CustomViewHolder(View itemView, Context context, List<T> data, Types type, String country){
        super(itemView);
        itemView.setOnClickListener(this);

        this.context = context;
        this.data = data;
        this.type = type;
        this.country = country;

        this.textView = itemView.findViewById(R.id.item_name);
    }

    CustomViewHolder(View itemView, Context context, List<T> data, Types type, String country, String state){
        super(itemView);
        itemView.setOnClickListener(this);

        this.context = context;
        this.data = data;
        this.type = type;
        this.country = country;
        this.state = state;


        this.textView = itemView.findViewById(R.id.item_name);
    }

    CustomViewHolder(View itemView, Context context, List<T> data, Types type, String country, String state, String city){
        super(itemView);
        itemView.setOnClickListener(this);

        this.context = context;
        this.data = data;
        this.type = type;
        this.country = country;
        this.state = state;
        this.city = city;


        this.textView = itemView.findViewById(R.id.item_name);
    }

    @Override
    public void onClick(View v) {
        int pos = getLayoutPosition();
        Intent intent = new Intent(context, SearchActivity.class);

        if(type == Types.COUNTRY){
            intent.putExtra("country_name", ((Country) data.get(pos)).getCountry());
            intent.putExtra("type", Types.STATE);
        }else if(type == Types.STATE){
            intent.putExtra("state_name", ((State) data.get(pos)).getState());
            intent.putExtra("country_name", country);
            intent.putExtra("type", Types.CITY);
        }else if(type == Types.CITY){
            intent.putExtra("city_name", ((City) data.get(pos)).getCity());
            intent.putExtra("state_name", state);
            intent.putExtra("country_name", country);
            intent.putExtra("type", Types.DETAILS);
        }

        intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<T> getCountries() {
        return data;
    }

    public void setCountries(List<T> data) {
        this.data = data;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}
