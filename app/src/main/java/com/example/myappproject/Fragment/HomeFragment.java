package com.example.myappproject.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myappproject.Database.AppDB;
import com.example.myappproject.Database.Entities.CurrentLocationEntity;
import com.example.myappproject.R;

public class HomeFragment extends Fragment {

    private TextView textView;
    AppDB db;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = AppDB.getDBInstance(this.getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        textView = view.findViewById(R.id.place_title);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
