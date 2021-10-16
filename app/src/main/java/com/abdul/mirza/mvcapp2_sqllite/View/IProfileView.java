package com.abdul.mirza.mvcapp2_sqllite.View;

import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Access;

import java.util.List;

public interface IProfileView {
    void updateUI(List<Access> items, String name, String surName, String studentId, String gpa, String createDate);
}
