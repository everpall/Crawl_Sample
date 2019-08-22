import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrawlTodayHumor {
    List<String> CrawlTodayHumorList;
    int CrawlTodayHumorCount;

    public void CrawlTodayHumor(){
        String url = "http://www.todayhumor.co.kr/board/list.php?kind=search&keyfield=name&keyword=%EB%AD%89%EA%B7%BC&Submit.x=0&Submit.y=0";
        Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

        try {
            doc = Jsoup.connect(url).get();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        Elements titles = doc.select("tbody");
        System.out.println("============================================================");
        System.out.println("<오늘의유머 작성글 확인>");
        System.out.println("============================================================");

        Iterator<Element> ie1 = titles.select("tr.view").iterator();

        CrawlTodayHumorList = new ArrayList<String>();
        while (ie1.hasNext()) {
            CrawlTodayHumorList.add(ie1.next().text());
        }
        CrawlTodayHumorCount = 0;
        //출력
        for(String Data: CrawlTodayHumorList){
            System.out.println(Data);
            CrawlTodayHumorCount++;
        }
        System.out.println("탐지 건수 : " + CrawlTodayHumorCount);
    }
    public List<String> GetCrawlTodayHumorList(){
        return CrawlTodayHumorList;
    }
    public int GetCrawlTodayHumorCount(){
        return CrawlTodayHumorCount;
    }
}
