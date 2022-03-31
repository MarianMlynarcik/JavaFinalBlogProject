package sk.ness.academy.dao;

import java.util.List;

import sk.ness.academy.domain.Article;
import sk.ness.academy.dto.ArticleT;

public interface ArticleDAO {

	  /** Returns {@link Article} with provided ID */
	  Article findByID(Integer articleId);

	  /** Returns all available {@link Article}s */
	  List<ArticleT> findAll();

	  /** Persists {@link Article} into the DB */
	  void persist(Article article);

	  /** Delete article from the DB */
	  void deleteArticleByID(Integer articleId);

	  List<ArticleT> searchArticles(String text);

	}
