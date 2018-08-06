package com.example.app.taskapp;

public class TaskModel {
    private String mTitle;
    private String mDescription;
    private String mImgUrl;
    private String mDate;
    private String mTime;

    public TaskModel(String mTitle, String mDescription, String mImgUrl, String mDate, String mTime) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mImgUrl = mImgUrl;
        this.mDate = mDate;
        this.mTime = mTime;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getImgUrl() {
        return mImgUrl;
    }

    public void setImgUrl(String mImgUrl) {
        this.mImgUrl = mImgUrl;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String mTime) {
        this.mTime = mTime;
    }
}
