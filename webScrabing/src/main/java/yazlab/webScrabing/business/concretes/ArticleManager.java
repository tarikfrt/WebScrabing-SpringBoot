package yazlab.webScrabing.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yazlab.webScrabing.business.abstracts.ArticleService;
import yazlab.webScrabing.dataAccess.abstracts.ArticleRepository;
import yazlab.webScrabing.entities.Article;

@Service
@AllArgsConstructor
public class ArticleManager implements ArticleService{

	private ArticleRepository articleRepository;
	private WebScrabing webScrabing;
	private Article article;
	@Override
	public void add(Article article) {
		
		this.articleRepository.save(article);
	}

	@Override
	public List<Article> getAll() {
		List<Article> articles =  articleRepository.findAll();
		return articles;
	}

	@Override
	public void delete(int id) {
		this.articleRepository.deleteById(id);
		
	}

	@Override
	public void addUrl(String url,int id) {
		
		this.articleRepository.save(webScrabing.scrabingAndAdd(article, url,id));
		
	}
	

}
