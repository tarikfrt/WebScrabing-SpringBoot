package yazlab.webScrabing.apiController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import yazlab.webScrabing.business.abstracts.ArticleService;
import yazlab.webScrabing.business.concretes.WebScrabing;
import yazlab.webScrabing.entities.Article;

@RestController
@RequestMapping("/api/articles")
@AllArgsConstructor
@CrossOrigin
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	

	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() Article article)
	{
		this.articleService.add(article);
	}
	
	@PostMapping("/add/article")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void addUrl(@RequestBody() @Valid() String url,int id)
	{
		
		this.articleService.addUrl(url,id);
		
	}
	
	@GetMapping("/getAll")
	public List<Article> getAll()
	{
		return articleService.getAll();
	}
	@DeleteMapping("/delete/{id}")
	public void delete (@PathVariable int id)
	{
		this.articleService.delete(id);
	}
}
