package sk.ness.academy.dto;

public class AuthorStats {

	  private String authorName;
	  private Long articleCount;

	public AuthorStats(String authorName, Long articleCount) {
		this.authorName = authorName;
		this.articleCount = articleCount;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Long getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(Long articleCount) {
		this.articleCount = articleCount;
	}
}
