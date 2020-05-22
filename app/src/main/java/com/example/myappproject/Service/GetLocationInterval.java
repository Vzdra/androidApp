package com.example.myappproject.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.myappproject.Database.AppDB;
import com.example.myappproject.Networking.Client.RetrofitClient;
import com.example.myappproject.Networking.Endpoints.GetDataService;
import com.example.myappproject.Networking.ResponseStructures.DataObject;
import com.example.myappproject.Networking.ResponseStructures.InfoResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetLocationInterval extends Service {

    private int INTERVAL = 3600000;
    private Handler iHandler;
    AppDB db;
    private static GetLocationInterval instance;

    @Override
    public void onCreate() {
        super.onCreate();
        iHandler = new Handler();
        db = AppDB.getDBInstance(this);
        executeAPICall.run();
    }

    private Runnable executeAPICall = new Runnable() {
        @Override
        public void run() {
            GetDataService service = RetrofitClient.getRetrofitInstance().create(GetDataService.class);
            Call<InfoResponse> call = service.nearestCityResults("d0aad5b7-d828-4530-9b29-919746a39518");
            call.enqueue(new Callback<InfoResponse>() {
                @Override
                public void onResponse(Call<InfoResponse> call, Response<InfoResponse> response) {
                    if(response.body()!=null){
                        if(response.body().getStatus().equals("success")){
                            DataObject temp = response.body().getData();
                            db.nearestPlaceAccess().nukeTable();
                            db.nearestPlaceAccess().insertLocation(
                                temp.getCountry(),
                                temp.getState(),
                                temp.getCity(),
                                temp.getLocation().getCoordinates()[0],
                                temp.getLocation().getCoordinates()[1],
                                temp.getCurrent().getWeather().getTp(),
                                temp.getCurrent().getWeather().getPr(),
                                temp.getCurrent().getWeather().getHu(),
                                temp.getCurrent().getWeather().getWs(),
                                temp.getCurrent().getWeather().getWd(),
                                temp.getCurrent().getPollution().getAqius()
                            );
                        }
                    }
                }

                @Override
                public void onFailure(Call<InfoResponse> call, Throwable t) {
                    System.out.println(t);
                }
            });
            iHandler.postDelayed(this, INTERVAL);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
