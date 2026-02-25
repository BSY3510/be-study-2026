package com.example.be_study_2026.week6_advanced;

public class Todo {

    private Long id;

    private String content;

    private boolean isDone;

    public Todo(Long id, String content, boolean isDone) {
        this.id = id;
        this.content = content;
        this.isDone = isDone;
    }

    public Long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public boolean getIsDone() {
        return this.isDone;
    }

}
