package sk.ness.academy.dao;

import sk.ness.academy.domain.Article;
import sk.ness.academy.domain.Comment;

import java.util.List;

public interface CommentDAO {

    /** Returns all available {@link Article}s */
    List<Comment> findAll();

    void persist(Comment comment);

    void deleteComment(final Integer commentId);

}
