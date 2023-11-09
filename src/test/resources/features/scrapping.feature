Feature: Addteq Web Pages Scraping Verification

  Scenario Outline: Verify web scraping on a webpage for missing information
    Given the URL "<webpage>" to scrape
    When I scrape the webpage
    Then I should see that the following fields exist:
      | Title         |
      | Type          |
      | Image         |
      | Description   |
      | Author        |
      | Publish Date  |

    Examples:
    |webpage|
    |https://www.addteq.com/products/excellentable/|
    |https://www.addteq.com/products/              |
    |https://www.addteq.com/products/unstoppable/  |
    |https://www.addteq.com/products/mscgen/       |
    |https://www.addteq.com/products/graphviz/     |
