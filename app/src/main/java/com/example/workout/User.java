package com.example.workout;

import android.net.Uri;

import java.io.Serializable;

import retrofit2.http.Url;

public class User implements Serializable {
    private  String demdExercises;
    private int demname;
    private String name;
    private String imgname;

    public User(int demname, String name, String imgname) {
        this.demname = demname;
        this.name = name;
        this.imgname = imgname;
    }

    public User(){
    }

    public int getDemname() {
        return demname;
    }
    public String getDemdExercises() {
        return demname+" exercises";
    }

    public void setDemname(int demname) {
        this.demname = demname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

}
