package sk.ness.academy.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import sk.ness.academy.dao.ArticleDAO;
import sk.ness.academy.domain.Article;
import sk.ness.academy.dto.ArticleT;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

  @Resource
  private ArticleDAO articleDAO;

  @Override
  public Article findByID(final Integer articleId) {
      return this.articleDAO.findByID(articleId);
  }

  @Override
  public List<ArticleT> findAll() {
	  return this.articleDAO.findAll();
  }

  @Override
  public void createArticle(final Article article) {
	  this.articleDAO.persist(article);
  }

  @Override
  public void ingestArticles(final String jsonArticles) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      Article[] data = objectMapper.readValue(new File(jsonArticles), Article[].class);
      for (Article art : data) {
        this.articleDAO.persist(art);
      }
    } catch (IOException e) {
        e.printStackTrace();
    }
  }

  @Override
  public void deleteArticleByID(final Integer articleId) {
      this.articleDAO.deleteArticleByID(articleId);
  }

  @Override
  public List<ArticleT> searchArticles(String searchText) {
    return this.articleDAO.searchArticles(searchText);
  }


}
