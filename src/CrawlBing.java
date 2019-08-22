import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrawlBing {
    List<String> CrawlBingList;
    int CrawlBingCount;

    public void CrawlBing(){
        String url = "https://www.bing.com/search?q=everpall";
        Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

        try {
            doc = Jsoup.connect(url).get();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        Elements element = doc.select("div");


        Iterator<Element> ie1 = element.select("li.b_algo h2").iterator();
        Iterator<Element> ie2 = element.select("div.b_caption p").iterator();
        System.out.println("============================================================");
        System.out.println("<Bing 검색 결과>");
        System.out.println("============================================================");


        CrawlBingList = new ArrayList<String>();
        while (ie1.hasNext()) {
            CrawlBingList.add(ie1.next().text() + "\t " +
                    ie2.next().text());
        }

        CrawlBingCount = 0;
        //출력
        for(String Data: CrawlBingList){
            System.out.println(Data);
            CrawlBingCount++;
        }
        System.out.println("탐지 건수 : " + CrawlBingCount);

    }
    public List<String> GetCrawlBingList(){
        return CrawlBingList;
    }
    public int GetCrawlBingCount(){
        return CrawlBingCount;
    }
}
