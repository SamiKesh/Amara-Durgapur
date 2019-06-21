package com.nnk.DurgapurTourism;

public class AddReview {
    private String id;
    private  String name;
    private  String review;
    private String rating;
    private String emailId;
    private String author;
    public AddReview() {
    }

    public AddReview(String id, String name, String review, String rating, String emailId, String author) {
        this.id = id;
        this.name = name;
        this.review = review;
        this.rating = rating;
        this.emailId = emailId;
        this.author = author;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReview() {
        return review;
    }

    public String getRating() {
        return rating;
    }

}
