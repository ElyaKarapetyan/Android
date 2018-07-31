package com.example.student.searchuser;

public class User {
    private String name;
    private String description;
    private String imageUrl;
    private String phoneNumber;
    private String emailAddress;
    private float rating;

    public User(String name, String description, String imageUrl, String phoneNumber, String emailAddress, float rating) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
