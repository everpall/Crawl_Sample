import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlNate {

    List<String> CrawlNateCafeList;
    int CrawlNateCafeCount;

    List<String> CrawlNateSiteList;
    int CrawlNateSiteCount;

    List<String> CrawlNateWebPaperList;
    int CrawlNateWebPaperCount;

    public void CrawlNateCafe(){
        String url = "https://search.daum.net/nate?w=cafe&nil_search=btn&DA=NTB&enc=utf8&ASearchType=1&lpp=10&rlang=0&q=everpall";
        Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

        try {
            doc = Jsoup.connect(url).get();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        Elements titles = doc.select("div.cont_inner");
        System.out.println("============================================================");
        System.out.println("<Nate 카페 게시글>");
        System.out.println("============================================================");

        CrawlNateCafeCount = 0;
        CrawlNateCafeList = new ArrayList<String>();

        for(Element element: titles) { // 3. Elemntes 길이만큼 반복한다.
            CrawlNateCafeList.add(element.text());
            CrawlNateCafeCount++;
            System.out.println("message : "+element.text()); // 4. 원하는 요소가 출력된다.
        }

        System.out.println("탐지 건수 : " + CrawlNateCafeCount);

    }
    public void CrawlNateSite(){
        String url = "https://search.daum.net/nate?w=site&nil_search=btn&DA=NTB&enc=utf8&lpp=10&q=everpall";
        Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

        try {
            doc = Jsoup.connect(url).get();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        Elements titles = doc.select("div.cont_inner");
        System.out.println("============================================================");
        System.out.println("<Nate 사이트 게시글>");
        System.out.println("============================================================");

        CrawlNateSiteCount = 0;
        CrawlNateSiteList = new ArrayList<String>();

        for(Element element: titles) { // 3. Elemntes 길이만큼 반복한다.
            CrawlNateSiteList.add(element.text());
            CrawlNateSiteCount++;
            System.out.println("message : "+element.text()); // 4. 원하는 요소가 출력된다.
        }

        System.out.println("탐지 건수 : " + CrawlNateSiteCount);

    }
    public void CrawlNateWebPaper(){
        String url = "https://search.daum.net/nate?w=web&nil_search=btn&DA=NTB&enc=utf8&lpp=10&q=everpall";
        Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

        try {
            doc = Jsoup.connect(url).get();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        Elements titles = doc.select("div.cont_inner");
        System.out.println("============================================================");
        System.out.println("<Nate 웹문서 게시글>");
        System.out.println("============================================================");

        CrawlNateWebPaperCount = 0;
        CrawlNateWebPaperList = new ArrayList<String>();

        for(Element element: titles) { // 3. Elemntes 길이만큼 반복한다.
            CrawlNateWebPaperList.add(element.text());
            CrawlNateWebPaperCount++;
            System.out.println("message : "+element.text()); // 4. 원하는 요소가 출력된다.
        }
        System.out.println("탐지 건수 : " + CrawlNateWebPaperCount);
    }
    public List<String> GetCrawlNateCafeList(){
        return CrawlNateCafeList;
    }
    public int GetCrawlNateCafeCount(){
        return CrawlNateCafeCount;
    }

    public List<String> GetCrawlNateSiteList(){
        return CrawlNateSiteList;
    }
    public int GetCrawlNateSiteCount(){
        return CrawlNateSiteCount;
    }

    public List<String> GetCrawlNateWebPaperList(){
        return CrawlNateWebPaperList;
    }
    public int GetCrawlNateWebPaperCount(){
        return CrawlNateWebPaperCount;
    }
}
