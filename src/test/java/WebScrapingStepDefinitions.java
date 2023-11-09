import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

public class WebScrapingStepDefinitions {
    private String url;
    private WebPageScraper scraper;
    private Map<String, String> scrapedData;

    @Given("the URL {string} to scrape")
    public void the_url_to_scrape(String url) {
        this.url = url;
        scraper = new WebPageScraper();
    }

    @When("I scrape the webpage")
    public void i_scrape_the_webpage() {
        scrapedData = scraper.scrapePage(url);
    }

    @Then("I should see that the following fields exist:")
    public void i_should_see_that_the_following_fields_exist(List<String> fieldsToCheck) {
        for (String field : fieldsToCheck) {
            String value = scrapedData.get(field);
            assertNotNull("Field not found: " + field, scrapedData.get(field));
            assertTrue("Field is an empty string: " + field, !value.trim().isEmpty());
        }
    }
}
