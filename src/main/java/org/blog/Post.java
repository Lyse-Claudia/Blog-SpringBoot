package org.blog;

import java.util.Objects;

public class Post {
    private int id;
    private String title;
    private String content;
    private User author;

    public Post() {
    }

    public Post(int id, String title, String content, User author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id && Objects.equals(title, post.title) && Objects.equals(content, post.content) && Objects.equals(author, post.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, author);
    }
}
