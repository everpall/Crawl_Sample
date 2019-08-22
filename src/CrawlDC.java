import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlDC {
    List<String> CrawlDCList;
    int CrawlDCount;


    public void CrawlDC() {
        String url = "https://gallog.dcinside.com/everpall01";
        Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

        try {
            doc = Jsoup.connect(url).get();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        Elements element = doc.select("div");
        System.out.println("============================================================");
        System.out.println("<디시인사드 갤러리 게시글 & 댓글>");
        System.out.println("============================================================");
        System.out.println((element.select("h2.tit").get(0).text()));
        String str = element.select("span.num").get(0).text();
        str = str.replaceAll("[^0-9]", "");
        int count1 = Integer.parseInt(str);
        int start = 0;

        CrawlDCount = 0;
        CrawlDCList = new ArrayList<String>();

        for (; start < count1; start++) {
            CrawlDCList.add(element.select("div.cont.box1").get(start).text() + "\t" + element.select("div.cont.box2").get(start).text() + "\t" + element.select("div.cont.box3").get(start).text());
        }
        count1 = start;

        System.out.println("============================================================");
        System.out.println((element.select("h2.tit").get(1).text()));
        String str2 = element.select("span.num").get(1).text();
        str2 = str2.replaceAll("[^0-9]", "");
        int count2 = Integer.parseInt(str2);

        for (; start < count1 + count2; start++) {
            CrawlDCList.add((element.select("div.cont.box1").get(start).text()) + "\t" + (element.select("div.cont.box2").get(start).text()) + "\t" + (element.select("div.cont.box3").get(start).text()));
        }
        System.out.println("============================================================");

        //출력
        for(String Data: CrawlDCList){
            System.out.println(Data);
            CrawlDCount++;
        }
        System.out.println("탐지 건수 : " + CrawlDCount);
    }
    public List<String> GetCrawlDCList(){
        return CrawlDCList;
    }
    public int GetCrawlDCount(){
        return CrawlDCount;
    }
}
