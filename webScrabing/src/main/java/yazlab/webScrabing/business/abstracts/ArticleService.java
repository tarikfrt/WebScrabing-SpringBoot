package yazlab.webScrabing.business.abstracts;

import java.util.List;

import yazlab.webScrabing.entities.Article;

public interface ArticleService {
	
	
	
	
	List<Article> getAll();
	void add (Article article);
	void delete (int id);
	public void addUrl(String url,int id);

}
