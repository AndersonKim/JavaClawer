package core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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
            doc = Jsoup.connect("http://www.open-open.com/jsoup/load-document-from-url.htm").get();
            String title = doc.title();
            System.out.println(title);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
