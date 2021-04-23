package com.abhiroop.desipopzsalesclient.repository;

import android.content.Context;

import com.abhiroop.desipopzsalesclient.database.AppInfoEntity;

public class DataRepository {

    private static AppInfoEntity data;
    private static Context mContext;
    private static DataRepository mDataRepository;
    private LocalRepository localRepository;

    public DataRepository(Context context,  LocalRepository localRepository) {
        this.localRepository = localRepository;
        getLocalData(localRepository);
    }

    public static DataRepository getInstance(Context context, LocalRepository localRepository/*, RemoteRepository remoteRepository*/) {
        if (mDataRepository == null) {
            mDataRepository = new DataRepository(context,/* remoteRepository,*/ localRepository);
            getLocalData(localRepository);
        }
        return mDataRepository;
    }

    public static AppInfoEntity getLocalData(LocalRepository localRepository) {

        // if get usr data is blank then set the default data and save it to the DB
        if (null != localRepository && null != localRepository.appRoomDao()) {
            data = localRepository.appRoomDao().getEntity();
            if (null == data) {
                localRepository.appRoomDao().deleteAll();
                localRepository.appRoomDao().insert(setDefaultLocalData());
                data = localRepository.appRoomDao().getEntity();
            }
        }
        return data;
    }
    public static AppInfoEntity setDefaultLocalData() {
        // if get usr data is blank then set the default data and save it to the DB
        AppInfoEntity data = new AppInfoEntity();
        data.setId(1);
        data.setItemQuantity(0);
        data.setItemType("Nothing added");
        data.setShopName("No shop found");
        data.setShopLocation("No shop location found");
        return data;
    }


}
