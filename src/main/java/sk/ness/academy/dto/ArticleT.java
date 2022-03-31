package sk.ness.academy.dto;

import sk.ness.academy.domain.Article;

import java.util.Date;

public class Article2 {

    private Integer id;
    private String title;
    private String text;
    private String author;
    private Date createDate;

    public Article2(Integer id, String title, String text, String author, Date createDate) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.author = author;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createTimestamp) {
        this.createDate = createTimestamp;
    }
}
