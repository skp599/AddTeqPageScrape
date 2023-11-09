import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WebPageScraper {
    public Map<String, String> scrapePage(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Map<String, String> scrapedData = new HashMap<>();

            scrapedData.put("Title", document.title());
            scrapedData.put("Type", document.select("meta[property=og:type]").attr("content"));
            scrapedData.put("Image", document.select("meta[property=og:image]").attr("content"));
            scrapedData.put("Description", document.select("meta[property=og:description]").attr("content"));
            scrapedData.put("Author", document.select("meta[property=og:site_name]").attr("content"));
            scrapedData.put("Publish Date", document.select("meta[property=article:published_time]").attr("content"));

            return scrapedData;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
