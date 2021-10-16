package com.abdul.mirza.mvcapp2_sqllite.SQLLite;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.abdul.mirza.mvcapp2_sqllite.SQLLite.dao.DaoAccess;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.dao.DaoProfile;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Access;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Profile;


@Database(entities = {Access.class, Profile.class}, version = 8)
public abstract class SQLLiteHelper extends RoomDatabase {

    private static volatile SQLLiteHelper instance;
    private static final String DB_NAME = "db";

    protected SQLLiteHelper(){}

    private static SQLLiteHelper create(Context context) {
        return Room.databaseBuilder(context, SQLLiteHelper.class,DB_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }

    public static synchronized SQLLiteHelper getInstance(Context context){
        if(instance == null)
        {
            instance = create(context);
        }

        return instance;
    }

    public abstract DaoAccess daoAccess();
    public abstract DaoProfile daoProfile();
}