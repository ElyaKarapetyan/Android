package com.example.elya.searchusers;

public class User {
    private String mImageUrl;
    private String mName;
    private String mDescription;
    private String mEmailAddress;
    private String mPhonNumber;
    private float mRating;

    public User(String mImageUrl, String mName, String mDescription, String mEmailAddress, String mPhonNumber, float mRating) {
        this.mImageUrl = mImageUrl;
        this.mName = mName;
        this.mDescription = mDescription;
        this.mEmailAddress = mEmailAddress;
        this.mPhonNumber = mPhonNumber;
        this.mRating = mRating;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmEmailAddress() {
        return mEmailAddress;
    }

    public void setmEmailAddress(String mEmailAddress) {
        this.mEmailAddress = mEmailAddress;
    }

    public String getmPhonNumber() {
        return mPhonNumber;
    }

    public void setmPhonNumber(String mPhonNumber) {
        this.mPhonNumber = mPhonNumber;
    }

    public float getmRating() {
        return mRating;
    }

    public void setmRating(float mRating) {
        this.mRating = mRating;
    }
}
