package yazlab.webScrabing.entities;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "articles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Article {
	
	@Id
	private int articleId;
	
	private String articleName;
	
	private String writers;
	
	private String typeOfArticle;
	
	private String publicationDate;
	
	private String publisherName;
	
	private String keyWords;
	
	private String searchKeyword;
	
	private String summary;
	
	private String referances;
	
	private String url;
	
	
}
