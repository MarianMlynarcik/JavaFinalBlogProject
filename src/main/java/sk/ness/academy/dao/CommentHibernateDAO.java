package sk.ness.academy.dao;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import sk.ness.academy.domain.Comment;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentHibernateDAO implements CommentDAO{

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Comment> findAll() {
        return this.sessionFactory.getCurrentSession().createSQLQuery("select * from comments")
                .addEntity(Comment.class).list();
    }

    @Override
    public void persist(final Comment comment) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(comment);
    }

    @Override
    public void deleteComment(final Integer commentId) {
        try{
            Comment comment = this.sessionFactory.getCurrentSession().load(Comment.class, commentId);
            this.sessionFactory.getCurrentSession().delete(comment);
            this.sessionFactory.getCurrentSession().flush();
        } catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
