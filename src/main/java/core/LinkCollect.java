package core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * 收集指定的url
 * edited by AndersonKim
 * at 2018/10/29
 */
public class LinkCollect {
    public static void main(String args[]){
        Document doc = null;
        try {
            doc = Jsoup.connect("https://insights.thoughtworks.cn/").get();
            String title = doc.title();
            System.out.println(title);
            Elements links = doc.select("a[href]");
            for (Element element:links){
                System.out.println(element.attr("abs:href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
