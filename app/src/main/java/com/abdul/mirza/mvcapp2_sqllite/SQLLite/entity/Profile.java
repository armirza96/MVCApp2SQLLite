package com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

@Entity(tableName = "profile",indices = {@Index(value = {"studentId"},
        unique = true)})
public class Profile {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "surname")
    private String surName;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "studentId")
    private String studentId;

    @ColumnInfo(name = "gpa")
    private String gpa;

    @ColumnInfo(name = "timestamp")
    private String timeStamp;

    public Profile(String name, String surName, String studentId, String gpa) {
        this.name = name;
        this.surName = surName;
        this.studentId = studentId;
        this.gpa = gpa;

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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
