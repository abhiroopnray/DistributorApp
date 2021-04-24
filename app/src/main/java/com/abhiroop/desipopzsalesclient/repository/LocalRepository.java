package com.abhiroop.desipopzsalesclient.repository;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.abhiroop.desipopzsalesclient.common.Constants;
import com.abhiroop.desipopzsalesclient.database.AppRoomDao;
import com.abhiroop.desipopzsalesclient.database.DistributorInfoEntity;


@Database(entities = {DistributorInfoEntity.class}, version = 1)
public abstract  class LocalRepository extends RoomDatabase {

    private static LocalRepository sInstance;

    public static synchronized LocalRepository getInstance(Context context){
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(), LocalRepository.class, Constants.APP_DATABASE_NAME).
                    allowMainThreadQueries()/*.addMigrations(MIGRATION_4_5, MIGRATION_5_6, MIGRATION_4_6)*/
                    /*.fallbackToDestructiveMigrationFrom(1, 2, 3, 4, 5, 6, 7)
                    .fallbackToDestructiveMigrationOnDowngrade()*/
                    .build();
        }
        return sInstance;
    }

    public abstract AppRoomDao appRoomDao();
}
