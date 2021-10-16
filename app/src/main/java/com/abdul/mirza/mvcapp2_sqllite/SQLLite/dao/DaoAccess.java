package com.abdul.mirza.mvcapp2_sqllite.SQLLite.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;

import com.abdul.mirza.mvcapp2_sqllite.SQLLite.Converter;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Access;

import java.util.List;

@TypeConverters(Converter.class)
@Dao
public interface DaoAccess {
    @Query("SELECT * FROM access WHERE profileID=:id ORDER BY TIMESTAMP DESC")
    List<Access> getAll(int id);

    @Query("SELECT * FROM access WHERE id=:id")
    Access findById(int id);

    @Insert
    void insertAll(Access... entities);


    @Delete
    void delete(Access entity);
}
