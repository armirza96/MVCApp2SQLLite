package com.abdul.mirza.mvcapp2_sqllite.SQLLite;

import androidx.room.TypeConverter;

public class Converter {
    @TypeConverter
    public TYPE toType(String value) {
        return TYPE.valueOf(value);
    }

    @TypeConverter
    public String fromType (TYPE type) {
        return type.name();
    }
}
