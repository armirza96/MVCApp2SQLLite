package com.abdul.mirza.mvcapp2_sqllite.Controller;

import android.content.Context;

import com.abdul.mirza.mvcapp2_sqllite.SQLLite.SQLLiteHelper;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Access;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Profile;

public class DialogController implements IDialogController{

    SQLLiteHelper helper;
    public DialogController(Context context) {
        helper = SQLLiteHelper.getInstance(context);
    }

    @Override
    public boolean onSaveData(Profile item) {
        try {
            helper.daoProfile().insertAll(item);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
