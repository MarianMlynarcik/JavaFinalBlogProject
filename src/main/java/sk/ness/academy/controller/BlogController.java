package sk.ness.academy.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;
import sk.ness.academy.domain.Article;
import sk.ness.academy.domain.Comment;
import sk.ness.academy.dto.ArticleT;
import sk.ness.academy.dto.Author;
import sk.ness.academy.dto.AuthorStats;
import sk.ness.academy.service.ArticleService;
import sk.ness.academy.service.AuthorService;
import sk.ness.academy.service.CommentService;

@RestController
public class BlogController {

  @Resource
  private CommentService commentService;

  @Resource
  private ArticleService articleService;

  @Resource
  private AuthorService authorService;

  // ~~ Article
  @RequestMapping(value = "articles", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<ArticleT> getAllArticles() {
      return this.articleService.findAll();
  }

  @RequestMapping(value = "articles/{articleId}", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public Article getArticle(@PathVariable final Integer articleId) {
    try{
      return this.articleService.findByID(articleId);
    }catch (NullPointerException e){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "articles/search/{searchText}", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<ArticleT> searchArticle(@PathVariable final String searchText) {
    try {
      return this.articleService.searchArticles(searchText);
    }catch (NullPointerException e){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "articles", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.CREATED)
  public void addArticle(@RequestBody final Article article) {
    try {
      this.articleService.createArticle(article);
    }catch (NullPointerException e){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "articles/{articleId}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.OK)
  public void deleteArticleByID(@PathVariable final Integer articleId) {
      this.articleService.deleteArticleByID(articleId);
  }

  @RequestMapping(value = "comments", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.CREATED)
  public void addArticle(@RequestBody final Comment comment) {
      this.commentService.createComment(comment);
  }

  @RequestMapping(value = "comments/{commentId}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.OK)
  public void deleteCommentByID(@PathVariable final Integer commentId) {
    try {
      this.commentService.deleteCommentByID(commentId);
    }catch (NullPointerException e){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  // ~~ Author
  @RequestMapping(value = "authors", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<Author> getAllAuthors() {
      return this.authorService.findAll();
  }

  @RequestMapping(value = "authors/stats", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<AuthorStats> authorStats() {
      return this.authorService.findAllWithNumArt();
  }
}

