import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlTwitter {
    List<String> CrawlTwitterList;
    int CrawlTwitterCount;

    public void CrawlTwitter(){
        String url = "https://twitter.com/everpall01";
        Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

        try {
            doc = Jsoup.connect(url).get();
        } catch (
                IOException e) {
            e.printStackTrace();
        }


        Elements titles = doc.select("div.js-tweet-text-container");
        System.out.println("============================================================");
        System.out.println("<트윗 게시글>");
        System.out.println("============================================================");

               CrawlTwitterCount = 0;
        CrawlTwitterList = new ArrayList<String>();

        for(Element element: titles) { // 3. Elemntes 길이만큼 반복한다.
            CrawlTwitterList.add(element.text());
            CrawlTwitterCount++;
            System.out.println("message : "+element.text()); // 4. 원하는 요소가 출력된다.
        }

        System.out.println("탐지 건수 : " + CrawlTwitterCount);
    }
    public List<String> GetCrawlTwitterList(){
        return CrawlTwitterList;
    }
    public int GetCrawlTwitterCount(){
        return CrawlTwitterCount;
    }
}
