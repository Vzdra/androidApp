package com.example.myappproject.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myappproject.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback{

    private GoogleMap gMap;
    private MapView mapView;
    private double lat;
    private double lng;
    private int aiq;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        mapView = view.findViewById(R.id.mapView);

        lat = getArguments().getDouble("lat");
        lng = getArguments().getDouble("lon");
        aiq = getArguments().getInt("ind");

        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap){
        gMap = googleMap;
        LatLng coords = new LatLng(lng, lat);
        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(coords, 15);
        gMap.animateCamera(location);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(coords);
        markerOptions.title("AIQ: " + Integer.toString(aiq));

        gMap.addMarker(markerOptions);
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    public static MapFragment newInstance(double lat, double lon, int index){
        MapFragment frag = new MapFragment();
        Bundle args = new Bundle();
        args.putDouble("lat", lat);
        args.putDouble("lon", lon);
        args.putInt("ind", index);
        frag.setArguments(args);

        return frag;
    }
}
