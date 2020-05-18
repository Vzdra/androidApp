package com.example.myappproject.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myappproject.Database.Access.NearestPlaceAccess;
import com.example.myappproject.Database.Entities.CurrentLocationEntity;

@Database(entities = {CurrentLocationEntity.class}, version = 1)
public abstract class AppDB extends RoomDatabase {
    private static final String DB_NAME = "appdb";
    private static AppDB instance;

    public static synchronized AppDB getDBInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDB.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract NearestPlaceAccess nearestPlaceAccess();
}
