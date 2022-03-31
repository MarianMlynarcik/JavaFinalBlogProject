package sk.ness.academy.service;

import sk.ness.academy.domain.Article;
import sk.ness.academy.domain.Comment;

import java.util.List;

public interface CommentService {

    /** Returns all available {@link Article}s */
    List<Comment> findAll();

    /** Creates new {@link Article} */
    void createComment(Comment comment);

    void deleteCommentByID(Integer commentId);

}
