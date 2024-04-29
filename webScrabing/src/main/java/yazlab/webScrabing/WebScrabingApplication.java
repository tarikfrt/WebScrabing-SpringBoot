package yazlab.webScrabing;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import yazlab.webScrabing.business.concretes.WebScrabing;
import yazlab.webScrabing.entities.Article;

@SpringBootApplication
public class WebScrabingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebScrabingApplication.class, args);
		
		/*
		 * String url = "https://books.toscrape.com/";
		 * try { Document document = Jsoup.connect(url).get(); Elements books =
		 * document.select(".product_pod");
		 * 
		 * System.out.println("==================="); for (Element element : books) {
		 * String title = element.select("h3 > a").text(); String price =
		 * element.select(".price_color").text();
		 * 
		 * System.out.println(title+" - "+price); }
		 * 
		 * 
		 * 
		 * } catch (Exception e) { // TODO: handle exception }
		 */
		
//			String url = "https://dergipark.org.tr/en/pub/gsbdergi/issue/33564/372645"; // Web sayfasının URL'si
//        
//        try {
//            // URL'yi ziyaret ederek HTML içeriğini al
//            Document doc = Jsoup.connect(url).get();
//            
//            
//          //**********************************************************************//
//            Elements h3Elements = doc.select("div.tab-pane.active h3.article-title");
//            // Seçilen h3 etiketlerinin metin içeriğini yazdır
//            
//                System.out.println("Makalenin Adı: " + h3Elements.text());
//            
//            
//          //**********************************************************************//
//            
//            // Belirli bir CSS seçiciyi kullanarak istediğiniz veriyi seçin
//            Elements paragraphs = doc.select("div.article-abstract.data-section p");
//            // Seçilen verileri işleyin
//            StringBuilder sb = new StringBuilder();
//            for (Element paragraph : paragraphs) {
//                sb.append(paragraph.text()).append("\n");
//            }
//            // İşlenen verileri yazdırın
//            System.out.println("Makalenin Özeti: "+sb.toString());
//       
//          //**********************************************************************//
//            Element keywordsSection = doc.select("div.article-keywords").first();
//            // Keywords bölümündeki tüm <a> etiketlerini seç
//            Elements keywordLinks = keywordsSection.select("a");
//
//            // Ayıklanan kelimeleri bir string olarak topla
//            StringBuilder keywordsStringBuilder = new StringBuilder();
//            for (Element keywordLink : keywordLinks) {
//                keywordsStringBuilder.append(keywordLink.text()).append(",");
//            }
//
//            // Son virgülü kaldır
//            String keywords = keywordsStringBuilder.toString().replaceAll(",$", "");
//
//            // Ayıklanan kelimeleri yazdır
//            System.out.println("Anahtar kelimeler: " + keywords);  
//            //***************************************************************************//
//            Element ulElement = doc.select("ul.fa-ul").first(); // null kontrolü ekledik
//
//            if (ulElement != null) { // null kontrolü
//                // Referansları içeren li etiketlerini bulun
//                Elements liElements = ulElement.select("li");
//
//                // İlk 5 referansı ayıklayın
//                StringBuilder referencesBuilder = new StringBuilder();
//                for (int i = 0; i < 5 && i < liElements.size(); i++) {
//                    Element liElement = liElements.get(i);
//                    String reference = liElement.text();
//                    referencesBuilder.append(reference).append(", ");
//                }
//
//                // Ayıklanan referansları bir string olarak yazdırın
//                String references = referencesBuilder.toString().trim();
//                System.out.println("Referanslar : " + references);
//            } else {
//                System.out.println("Referans bulunamadı."); // Bulunamayan referansları işaretlemek için
//            }
//            
//            //*******************************************************************//
//         // Tarih bilgisini içeren td etiketlerini seçin
//            Elements dateElements = doc.select("th:contains(Publication Date) + td");
//
//            // Tarih bilgisini alın
//            String publicationDate = "";
//            if (!dateElements.isEmpty()) {
//                publicationDate = dateElements.first().text();
//            }
//
//            // Tarih bilgisini yazdırın
//            System.out.println("Publication Date: " + publicationDate);
//            //********************************************************//
//            Elements authorElements = doc.select("table.record_properties th:contains(Authors) + td p");
//            
//            StringBuilder authors = new StringBuilder();
//            for (Element authorElement : authorElements) {
//                String authorName = authorElement.text();
//                authors.append(authorName).append(", ");
//            }
//            
//            // Son virgülü ve boşluğu kaldır
//            if (authors.length() > 0) {
//                authors.deleteCharAt(authors.length() - 2);
//            }
//            
//            System.out.println("Yazarlar: " + authors.toString());
//            //******************************************************//
//            Elements h1Elements = doc.select("h1");
//
//            // Eğer "h1" etiketi bulunduysa
//            if (!h1Elements.isEmpty()) {
//                // İlk bulunan "h1" etiketinin içeriğini al
//                Element h1Element = h1Elements.first();
//                
//                // İçeriği yazdır
//                System.out.println("Yayıncı adı : " + h1Element.text());
//            } else {
//                System.out.println("Yayınlanan dergi vya kitap bulunamadı.");
//            }
//            
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//		WebScrabing webScrabing = new WebScrabing();
//		Article article2 = new Article();
//				webScrabing.scrabingAndAdd(article2, "https://dergipark.org.tr/en/pub/gsbdergi/issue/33564/372645");
//		System.out.println(article2.getArticleName());

}
}
