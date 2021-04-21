package com.abhiroop.desipopzsalesclient.database;

import android.database.Cursor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.abhiroop.desipopzsalesclient.common.Constants;

/**
 * The interface Room dao.
 */
@Dao
public interface AppRoomDao {

    /**
     * Count int.
     *
     * @return the int
     */
    @Query("SELECT COUNT(*) FROM " + Constants.TABLE_NAME)
    int count();

    /**
     * Inserts a warrantyDao into the table.
     *
     * @param roomInfoEntity A new sosDao.
     * @return The row ID of the newly inserted sosDao.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(RoomInfoEntity roomInfoEntity);


    /**
     * Select all cheeses.
     *
     * @return A {@link Cursor} of all the cheeses in the table.
     */
    @Query("SELECT * FROM " + Constants.TABLE_NAME)
    Cursor selectAll();

    /**
     * Gets user.
     *
     * @return the user
     */
    @Query("SELECT * FROM " + Constants.TABLE_NAME)
    RoomInfoEntity getSOSUser();

    @Query("SELECT * FROM " + Constants.TABLE_NAME)
    LiveData<RoomInfoEntity> getLiveSOSUser();

    /**
     * Delete all.
     */
    @Query("DELETE FROM " + Constants.TABLE_NAME)
    void deleteAll();

    @Update
    int update(RoomInfoEntity... sosInfoEntities);
}
