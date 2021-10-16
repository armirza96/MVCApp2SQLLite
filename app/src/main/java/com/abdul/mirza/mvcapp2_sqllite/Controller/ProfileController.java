package com.abdul.mirza.mvcapp2_sqllite.Controller;

import android.content.Context;

import com.abdul.mirza.mvcapp2_sqllite.Model.ProfileModel;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.SQLLiteHelper;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.TYPE;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Access;
import com.abdul.mirza.mvcapp2_sqllite.View.IProfileView;

public class ProfileController implements IProfileController{
    IProfileView v;
    ProfileModel m;
    SQLLiteHelper helper;

    public ProfileController(IProfileView v, Context context, int id) {
        helper = SQLLiteHelper.getInstance(context);

        this.v = v;
        this.m = new ProfileModel(helper, id);

    }

    @Override
    public void onSetup() {
        v.updateUI(m.getItems(),
                "Name: " + m.getProfile().getName(),
                "Surname: " + m.getProfile().getSurName(),
                "ID: " + m.getProfile().getStudentId(),
                "GPA: " + m.getProfile().getGpa(),
                "Profile created: " + m.getProfile().getTimeStamp()
                );
    }

    @Override
    public void onCreateClosedAccess() {
        onCreateAccess(TYPE.CLOSED);
    }

    @Override
    public void onCreateOpenAccess() {
        onCreateAccess(TYPE.OPENED);
    }

    @Override
    public void onCreateDeletedAccess() {
        onCreateAccess(TYPE.DELETED);
        helper.daoProfile().delete(m.getProfile());
    }

    private void onCreateAccess(TYPE type) {
        Access a = new Access(m.getProfile().getId(), type);
        helper.daoAccess().insertAll(a);
    }
}
