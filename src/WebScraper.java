import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
  /**
   * Retrieve contents from a URL and return them as a string.
   *
   * @param url url to retrieve contents from
   * @return the contents from the url as a string, or an empty string on error
   */
  public static String urlToString(final String url) {
    Scanner urlScanner;
    try {
      urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
    } catch (IOException e) {
      return "";
    }
    String contents = urlScanner.useDelimiter("\\A").next();
    urlScanner.close();
    return contents;
  }

  public static void main(String[] unused) {
      String websiteText = urlToString("http://erdani.com/tdpl/hamlet.txt");
      System.out.println(websiteText);
      int wordCount = 0;
      boolean inWhitespace = false;
      for (int i = 0; i < websiteText.length(); i++) {
          if (websiteText.charAt(i) == ' ') {
              inWhitespace = true;
          }
          if (websiteText.charAt(i) != ' ') {
              if (inWhitespace) {
                  wordCount++;
              }
              inWhitespace = false;
          }
      }
      System.out.println(wordCount);

      int singleWordCount = 0;
      String search = "Prince";
      int index = 0;
      while (index < websiteText.length()) {
          if (!websiteText.contains(search)) {
              break;
          } else {
              singleWordCount++;
              index = websiteText.indexOf(search) + search.length();
          }
      }
      System.out.println(singleWordCount);
  }


}
