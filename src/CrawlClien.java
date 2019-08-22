import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrawlClien {
    List<String> CrawlClienList;
    int CrawlClienCount;

    public void CrawlClien(){
        String url = "https://www.clien.net/service/search/board/park?sk=id&sv=moongos";
        Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

        try {
            doc = Jsoup.connect(url).get();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        Elements titles = doc.select("div");
        System.out.println("============================================================");
        System.out.println("<클리앙 작성글 확인>");
        System.out.println("============================================================");

        Iterator<Element> ie1 = titles.select("div.list_item.symph_row").iterator();

        CrawlClienList = new ArrayList<String>();
        while (ie1.hasNext()) {
            CrawlClienList.add(ie1.next().text());
        }
        CrawlClienCount = 0;
        //출력
        for(String Data: CrawlClienList){
            System.out.println(Data);
            CrawlClienCount++;
        }
        System.out.println("탐지 건수 : " + CrawlClienCount);
    }
    public List<String> GetCrawlClienList(){
        return CrawlClienList;
    }
    public int GetCrawlClienCount(){
        return CrawlClienCount;
    }
}
