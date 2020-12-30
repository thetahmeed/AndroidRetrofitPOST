package com.tahmeedul.androidretrofitpost.getpost;

public class PostArray {

    int userId;
    Integer id;
    String title, body;

    public PostArray(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

}
