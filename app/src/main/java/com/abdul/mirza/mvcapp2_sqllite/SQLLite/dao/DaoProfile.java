package com.abdul.mirza.mvcapp2_sqllite.SQLLite.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Profile;

import java.util.List;

@Dao
public interface DaoProfile {
    @Query("SELECT * FROM profile ORDER BY surname ASC")
    List<Profile> getAllOrderBySurName();

    @Query("SELECT * FROM profile ORDER BY studentId ASC")
    List<Profile> getAllOrderByStudentID();

    @Query("SELECT * FROM profile WHERE id=:id")
    Profile findById(int id);

    @Insert
    void insertAll(Profile... entities);

    @Delete
    void delete(Profile entity);
}
