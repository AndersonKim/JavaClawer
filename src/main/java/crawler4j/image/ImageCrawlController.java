package crawler4j.image;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Yasser Ganjisaffar
 */
public class ImageCrawlController {
    private static final Logger logger = LoggerFactory.getLogger(ImageCrawlController.class);

    public static void main(String[] args) throws Exception {
        args=new String[3];
        args[0]="D:\\Dev\\crawler4j\\data";
        args[1]="10";
        args[2]="D:\\Dev\\crawler4j\\image";
        if (args.length < 3) {
            logger.info("Needed parameters: ");
            logger.info("\t rootFolder (it will contain intermediate crawl data)");
            logger.info("\t numberOfCrawlers (number of concurrent threads)");
            logger.info("\t storageFolder (a folder for storing downloaded images)");
            return;
        }

        String rootFolder = args[0];
        int numberOfCrawlers = Integer.parseInt(args[1]);
        String storageFolder = args[2];

        CrawlConfig config = new CrawlConfig();
        config.setUserAgentString("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:62.0) Gecko/20100101 Firefox/62.0");
        config.setMaxDepthOfCrawling(5);
//        Collection<BasicHeader> headers=new ArrayList<BasicHeader>();
//        headers.add(new BasicHeader("",""));
//        headers.add(new BasicHeader("",""));
//        config.setDefaultHeaders(headers);
        config.setCrawlStorageFolder(rootFolder);

    /*
     * Since images are binary content, we need to set this parameter to
     * true to make sure they are included in the crawl.
     */
        config.setIncludeBinaryContentInCrawling(true);

        String[] crawlDomains = {"http://www.umei.cc/p/gaoqing/xiuren_VIP/20160726193407.htm"};

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
        for (String domain : crawlDomains) {
            controller.addSeed(domain);
        }

        ImageCrawler.configure(crawlDomains, storageFolder);

        controller.start(ImageCrawler.class, numberOfCrawlers);
    }
}
