package com.example.myappproject.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myappproject.Activity.SearchActivity;
import com.example.myappproject.Networking.ResponseStructures.City;
import com.example.myappproject.Networking.ResponseStructures.Country;
import com.example.myappproject.Networking.ResponseStructures.State;
import com.example.myappproject.R;

import java.util.List;

public class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Context context;
    private List<Country> countries;

    private TextView textView;

    CountryViewHolder(View itemView, Context context, List<Country> countries){
        super(itemView);
        itemView.setOnClickListener(this);

        this.context = context;
        this.countries = countries;

        this.textView = itemView.findViewById(R.id.ct_name);
    }

    @Override
    public void onClick(View v) {
        int pos = getLayoutPosition();
        Intent intent = new Intent(context, SearchActivity.class);
        intent.putExtra("country_name", countries.get(pos).getCountry());
        context.startActivity(intent);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}
