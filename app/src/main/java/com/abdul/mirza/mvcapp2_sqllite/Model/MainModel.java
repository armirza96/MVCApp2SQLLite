package com.abdul.mirza.mvcapp2_sqllite.Model;

import android.content.Context;

import com.abdul.mirza.mvcapp2_sqllite.SQLLite.SQLLiteHelper;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Profile;

import java.util.List;

public class MainModel {
    List<Profile> list;
    SQLLiteHelper helper;

    public MainModel(Context context) {
        helper = SQLLiteHelper.getInstance(context);
        list = helper.daoProfile().getAllOrderBySurName();
    }

    public int getTotalCount() {
        return list.size();
    }

    public List<Profile> getItems(boolean showSurNames) {
        if(showSurNames)
            list = helper.daoProfile().getAllOrderBySurName();
        else
            list = helper.daoProfile().getAllOrderByStudentID();
        return list;
    }
}
