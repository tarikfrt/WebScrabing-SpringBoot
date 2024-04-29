package yazlab.webScrabing.business.concretes;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import yazlab.webScrabing.entities.Article;

@Component
public class WebScrabing {
	
	public static Article scrabingAndAdd(Article article,String url,int id) {
		
		try {
            // URL'yi ziyaret ederek HTML içeriğini al
            Document doc = Jsoup.connect(url).get();
            
            article.setArticleId(id);
            article.setUrl(url);
            
          //**********************************************************************//
            Elements h3Elements = doc.select("div.tab-pane.active h3.article-title");
            // Seçilen h3 etiketlerinin metin içeriğini yazdır
            
            	article.setArticleName(h3Elements.text());
                System.out.println("Makalenin Adı: " + h3Elements.text());
            
            
          //**********************************************************************//
            
            // Belirli bir CSS seçiciyi kullanarak istediğiniz veriyi seçin
            Elements paragraphs = doc.select("div.article-abstract.data-section p");
            // Seçilen verileri işleyin
            StringBuilder sb = new StringBuilder();
            for (Element paragraph : paragraphs) {
                sb.append(paragraph.text()).append("\n");
            }
            // İşlenen verileri yazdırın
            article.setSummary(sb.toString());
            System.out.println("Makalenin Özeti: "+sb.toString());
       
          //**********************************************************************//
            Element keywordsSection = doc.select("div.article-keywords").first();
            // Keywords bölümündeki tüm <a> etiketlerini seç
            Elements keywordLinks = keywordsSection.select("a");

            // Ayıklanan kelimeleri bir string olarak topla
            StringBuilder keywordsStringBuilder = new StringBuilder();
            for (Element keywordLink : keywordLinks) {
                keywordsStringBuilder.append(keywordLink.text()).append(",");
            }

            // Son virgülü kaldır
            String keywords = keywordsStringBuilder.toString().replaceAll(",$", "");

            // Ayıklanan kelimeleri yazdır
            article.setKeyWords(keywords);
            System.out.println("Anahtar kelimeler: " + keywords);  
            //***************************************************************************//
            Element ulElement = doc.select("ul.fa-ul").first(); // null kontrolü ekledik

            if (ulElement != null) { // null kontrolü
                // Referansları içeren li etiketlerini bulun
                Elements liElements = ulElement.select("li");

                // İlk 5 referansı ayıklayın
                StringBuilder referencesBuilder = new StringBuilder();
                for (int i = 0; i < 5 && i < liElements.size(); i++) {
                    Element liElement = liElements.get(i);
                    String reference = liElement.text();
                    referencesBuilder.append(reference).append(", ");
                }

                // Ayıklanan referansları bir string olarak yazdırın
                String references = referencesBuilder.toString().trim();
                System.out.println("Referanslar : " + references);
                article.setReferances(references);
            } else {
                System.out.println("Referans bulunamadı.");
                // Bulunamayan referansları işaretlemek için
                article.setReferances("-");
            }
            
            //*******************************************************************//
         // Tarih bilgisini içeren td etiketlerini seçin
            Elements dateElements = doc.select("th:contains(Publication Date) + td");

            // Tarih bilgisini alın
            String publicationDate = "";
            if (!dateElements.isEmpty()) {
                publicationDate = dateElements.first().text();
            }

            // Tarih bilgisini yazdırın
            System.out.println("Publication Date: " + publicationDate);
            article.setPublicationDate(publicationDate);
            //********************************************************//
            Elements authorElements = doc.select("table.record_properties th:contains(Authors) + td p");
            
            StringBuilder authors = new StringBuilder();
            for (Element authorElement : authorElements) {
                String authorName = authorElement.text();
                authors.append(authorName).append(", ");
            }
            
            // Son virgülü ve boşluğu kaldır
            if (authors.length() > 0) {
                authors.deleteCharAt(authors.length() - 2);
            }
            
            System.out.println("Yazarlar: " + authors.toString());
            article.setWriters(authors.toString());
            //******************************************************//
            Elements h1Elements = doc.select("h1");

            // Eğer "h1" etiketi bulunduysa
            if (!h1Elements.isEmpty()) {
                // İlk bulunan "h1" etiketinin içeriğini al
                Element h1Element = h1Elements.first();
             // "h1" etiketinin içeriğini boşluğa göre parçala
                String[] words = h1Element.text().split("\\s+");
                // Son kelimeyi al
                String lastWord = words[words.length - 1];
                // Son kelimeyi ekrana yazdır
                System.out.println("Last Word: " + lastWord);
                // İçeriği yazdır
                System.out.println("Yayıncı adı : " + h1Element.text());
                article.setPublisherName(h1Element.text());
                article.setTypeOfArticle(lastWord);
            } else {
                System.out.println("Yayınlanan dergi vya kitap bulunamadı.");
                article.setPublisherName("-");
                article.setTypeOfArticle("-");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		return article;
		
	}
	
}
