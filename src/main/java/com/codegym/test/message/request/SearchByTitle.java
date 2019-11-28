package com.codegym.test.message.request;

public class SearchByTitle {
    private String title;
    private Long id;

    public SearchByTitle() {
    }

    public SearchByTitle(String title, Long id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
