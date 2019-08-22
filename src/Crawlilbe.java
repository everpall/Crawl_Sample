import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Crawlilbe {
    List<String> CrawlBingList;
    int CrawlBingCount;

    public void Crawlilbe(){
        String url = "http://www.ilbe.com/list/ilbe?searchType=nick_name&search=%EC%9E%91%EB%91%90%EB%8F%84%EB%A0%B9";
        Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

        try {
            doc = Jsoup.connect(url).get();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        Elements element = doc.select("div");


        Iterator<Element> ie1 = element.select("span.title").iterator();
        Iterator<Element> ie2 = element.select("span.global-nick.nick").iterator();
        Iterator<Element> ie3 = element.select("span.date").iterator();
        System.out.println("============================================================");
        System.out.println("<Bing 검색 결과>");
        System.out.println("============================================================");

        int list_count=0;
        CrawlBingList = new ArrayList<String>();

        List<String> CrawlBingList_1 = new ArrayList<String>();
        List<String> CrawlBingList_2 = new ArrayList<String>();
        List<String> CrawlBingList_3 = new ArrayList<String>();


        while (ie1.hasNext()) {
            CrawlBingList_1.add(ie1.next().text());
        }
        CrawlBingList_1.remove(0);
        CrawlBingList_1.remove(0);
        CrawlBingList_1.remove(0);

        while (ie2.hasNext()) {
            CrawlBingList_2.add(ie2.next().text());
        }

        CrawlBingList_2.remove(0);
        CrawlBingList_2.remove(0);
        CrawlBingList_2.remove(0);

        while (ie3.hasNext()) {
            CrawlBingList_3.add(ie3.next().text());
        }
        CrawlBingList_3.remove(0);
        CrawlBingList_3.remove(0);
        CrawlBingList_3.remove(0);
        CrawlBingList_3.remove(0);

        for(int i=0 ; i<CrawlBingList_1.size() ; i++){
            CrawlBingList.add(CrawlBingList_1.get(i).toString() + " 글쓴이 : " + CrawlBingList_2.get(i).toString()+ "날짜 : " + CrawlBingList_3.get(i).toString());
        }
        CrawlBingList.remove(0);
        CrawlBingList.remove(0);
        CrawlBingList.remove(0);

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
