package com.example.elya.films;

public class Film {
    String title;
    int imageId;
    String description;
    int rating;
    boolean isLiked;
    String wikiUrl;

    public Film(String title, int imageId, String description, int rating, boolean isLiked, String wikiUrl) {
        this.title = title;
        this.imageId = imageId;
        this.description = description;
        this.rating = rating;
        this.isLiked = isLiked;
        this.wikiUrl = wikiUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public String getWikiUrl() {
        return wikiUrl;
    }

    public void setWikiUrl(String wikiUrl) {
        this.wikiUrl = wikiUrl;
    }
}
