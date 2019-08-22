import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlDaum {
    List<String> CrawlDaumCafeList;
    int CrawlDaumCafeCount;

    List<String> CrawlDaumSiteList;
    int CrawlDaumSiteCount;

    List<String> CrawlDaumWebPaperList;
    int CrawlDaumWebPaperCount;

    public void CrawlDaumCafe(){
        String url = "http://search.daum.net/search?w=cafe&nil_search=btn&DA=NTB&enc=utf8&ASearchType=1&lpp=10&rlang=0&q=everpall";
        Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

        try {
            doc = Jsoup.connect(url).get();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        Elements titles = doc.select("div.cont_inner");
        System.out.println("============================================================");
        System.out.println("<다음 카페 게시글>");
        System.out.println("============================================================");

        CrawlDaumCafeCount = 0;
        CrawlDaumCafeList = new ArrayList<String>();

        for(Element element: titles) { // 3. Elemntes 길이만큼 반복한다.
            CrawlDaumCafeList.add(element.text());
            CrawlDaumCafeCount++;
            System.out.println("message : "+element.text()); // 4. 원하는 요소가 출력된다.
        }

        System.out.println("탐지 건수 : " + CrawlDaumCafeCount);

    }

    public void CrawlDaumSite(){
        String url = "http://search.daum.net/search?w=site&nil_search=btn&DA=NTB&enc=utf8&lpp=10&q=everpall";
        Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

        try {
            doc = Jsoup.connect(url).get();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        Elements titles = doc.select("div.cont_inner");
        System.out.println("============================================================");
        System.out.println("<다음 사이트 게시글>");
        System.out.println("============================================================");

        CrawlDaumSiteCount = 0;
        CrawlDaumSiteList = new ArrayList<String>();

        for(Element element: titles) { // 3. Elemntes 길이만큼 반복한다.
            CrawlDaumSiteList.add(element.text());
            CrawlDaumSiteCount++;
            System.out.println("message : "+element.text()); // 4. 원하는 요소가 출력된다.
        }

        System.out.println("탐지 건수 : " + CrawlDaumSiteCount);

    }

    public void CrawlDaumWebPaper(){
        String url = "http://search.daum.net/search?w=web&nil_search=btn&DA=NTB&enc=utf8&lpp=10&q=everpall";
        Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

        try {
            doc = Jsoup.connect(url).get();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        Elements titles = doc.select("div.cont_inner");
        System.out.println("============================================================");
        System.out.println("<다음 웹문서 게시글>");
        System.out.println("============================================================");

        CrawlDaumWebPaperCount = 0;
        CrawlDaumWebPaperList = new ArrayList<String>();

        for(Element element: titles) { // 3. Elemntes 길이만큼 반복한다.
            CrawlDaumWebPaperList.add(element.text());
            CrawlDaumWebPaperCount++;
            System.out.println("message : "+element.text()); // 4. 원하는 요소가 출력된다.
        }

        System.out.println("탐지 건수 : " + CrawlDaumWebPaperCount);

    }
    public List<String> GetCrawlDaumCafeList(){
        return CrawlDaumCafeList;
    }
    public int GetCrawlDaumCafeCount(){
        return CrawlDaumCafeCount;
    }

    public List<String> GetCrawlDaumSiteList(){
        return CrawlDaumSiteList;
    }
    public int GetCrawlDaumSiteCount(){
        return CrawlDaumSiteCount;
    }

    public List<String> GetCrawlDaumWebPaperList(){
        return CrawlDaumWebPaperList;
    }
    public int GetCrawlDaumWebPaperCount(){
        return CrawlDaumWebPaperCount;
    }
}
