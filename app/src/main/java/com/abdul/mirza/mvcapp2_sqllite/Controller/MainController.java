package com.abdul.mirza.mvcapp2_sqllite.Controller;

import android.content.Context;

import com.abdul.mirza.mvcapp2_sqllite.Model.MainModel;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.SQLLiteHelper;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Profile;
import com.abdul.mirza.mvcapp2_sqllite.View.IMainView;

import java.util.List;

public class MainController implements IMainController{
    IMainView v;
    MainModel m;
    boolean showSurnames = true;

    public MainController(IMainView mv, Context context) {
        this.v = mv;
        this.m = new MainModel(context);
    }

    @Override
    public void onSetup() {
        v.updateUI(m.getItems(showSurnames), getTextViewText(), showSurnames);
    }

    @Override
    public void changeState() {
        showSurnames = !showSurnames;
        v.updateUI(m.getItems(showSurnames), getTextViewText(), showSurnames);
    }

    private String getTextViewText() {
        return showSurnames ? (m.getTotalCount() + " Profiles, By Surname") : (m.getTotalCount() + " Profiles, By ID");
    }
}
