package sk.ness.academy.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import org.springframework.web.server.ResponseStatusException;
import sk.ness.academy.domain.Article;
import sk.ness.academy.dto.ArticleT;

@Repository
public class ArticleHibernateDAO implements ArticleDAO {

  @Resource(name = "sessionFactory")
  private SessionFactory sessionFactory;

  @Override
  public Article findByID(final Integer articleId) {
    Article art = this.sessionFactory.getCurrentSession().get(Article.class, articleId);
    Hibernate.initialize(art.getComments());
    return art;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<ArticleT> findAll() {
    return this.sessionFactory.getCurrentSession().createQuery("select new sk.ness.academy.dto.ArticleT(id, title, text, author, createTimestamp) from Article", ArticleT.class)
            .list();
  }

  @Override
  public void persist(final Article article) {
    this.sessionFactory.getCurrentSession().saveOrUpdate(article);
  }

  @Override
  public void deleteArticleByID(final Integer articleId) {
    try{
      Article article = this.sessionFactory.getCurrentSession().load(Article.class, articleId);
      this.sessionFactory.getCurrentSession().delete(article);
      this.sessionFactory.getCurrentSession().flush();
    } catch (EntityNotFoundException e){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public List<ArticleT> searchArticles(String text) {
    return this.sessionFactory.getCurrentSession()
            .createQuery("select new sk.ness.academy.dto.ArticleT(id, title, text, author, createTimestamp) from Article where author like '%"+text+"%' OR title like '%"+text+"%' OR text like '%"+text+"%'", ArticleT.class)
            .list();
  }
}
