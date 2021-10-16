package com.abdul.mirza.mvcapp2_sqllite.View;

import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Profile;

import java.util.List;

public interface IMainView {
    void updateUI(List<Profile> items, String text, boolean showSurnames);
    void onRecyclerViewUpdate(List<Profile> items, boolean showSurnames);
}
