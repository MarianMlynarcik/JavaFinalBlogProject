package sk.ness.academy.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
@SequenceGenerator(name = "comments_seq_store", sequenceName = "comments_seq", allocationSize = 1)
public class Comment {

    @Id
    @Column(name = "id", unique = true, nullable = false, precision = 10, scale = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_seq_store")
    private Integer id;

    @Column(name = "article_id", nullable = false)
    private Integer articleID;

    @Column(name = "author", length = 250)
    private String author;

    @Column(name = "text", length = 2000)
    private String text;

    @Column(name = "create_timestamp")
    @Temporal(TemporalType.DATE)
    private Date createDate;

    public Comment() {
        this.createDate = new Date();
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public Date getCreateTimestamp() {
        return createDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createDate = createTimestamp;
    }

    public Integer getArticleID() {
        return articleID;
    }

    public void setArticleID(Integer articleID) {
        this.articleID = articleID;
    }

}
