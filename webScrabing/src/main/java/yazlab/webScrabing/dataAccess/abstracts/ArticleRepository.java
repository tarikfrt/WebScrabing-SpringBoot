package yazlab.webScrabing.dataAccess.abstracts;

import org.springframework.data.mongodb.repository.MongoRepository;

import yazlab.webScrabing.entities.Article;

public interface ArticleRepository extends MongoRepository<Article, Integer>{

}
