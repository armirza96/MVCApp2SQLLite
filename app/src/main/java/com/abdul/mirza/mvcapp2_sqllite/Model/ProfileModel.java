package com.abdul.mirza.mvcapp2_sqllite.Model;

import android.content.Context;

import com.abdul.mirza.mvcapp2_sqllite.SQLLite.SQLLiteHelper;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.TYPE;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Access;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Profile;

import java.util.List;

public class ProfileModel {
    List<Access> list;
    Profile profile;

    public ProfileModel(SQLLiteHelper helper, int profileId) {
        list = helper.daoAccess().getAll(profileId);
        profile = helper.daoProfile().findById(profileId);
        Access a = new Access(profileId, TYPE.CREATED);
        a.setTimeStamp(profile.getTimeStamp());
        list.add(a);
    }

    public List<Access> getItems() {
        return list;
    }

    public Profile getProfile() {
        return profile;
    }
}
