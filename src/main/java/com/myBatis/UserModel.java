package com.myBatis;

import java.util.List;

/**
 * http://www.mamicode.com/info-detail-188913.html
 */
public class UserModel {
    private int uid;
    private String uname;
    private ClassModel classModel;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public ClassModel getClassModel() {
        return classModel;
    }

    public void setClassModel(ClassModel classModel) {
        this.classModel = classModel;
    }
}
