package com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.abdul.mirza.mvcapp2_sqllite.SQLLite.Converter;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.TYPE;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import static androidx.room.ForeignKey.CASCADE;

@TypeConverters(Converter.class)
@Entity(tableName = "access"/*,foreignKeys = @ForeignKey(entity = Profile.class,
        parentColumns = "id",
        childColumns = "profileID",
        onDelete = CASCADE)*/ )
public class Access {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "profileID")
    private int profileID;

    @ColumnInfo(name = "type")
    private TYPE type;

    @ColumnInfo(name = "timestamp")
    private String timeStamp;

    public Access(int profileID, TYPE type) {
        this.profileID = profileID;
        this.type = type;
        long stamp = System.currentTimeMillis();

        String date = new SimpleDateFormat("yyyy-MM-dd @ hh:mm:ss").format(stamp);

        timeStamp = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProfileID() {
        return profileID;
    }

    public void setProfileID(int profileID) {
        this.profileID = profileID;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}


