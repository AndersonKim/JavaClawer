package core;

import java.util.HashMap;
import java.util.Set;

/**
 * 抓取的页面模型
 * edited by AndersonKim
 * at 2018/10/29
 */
public class Page {
    //当前页面的地址
    String url;
    //从当前页面出发的页面地址
    Set<String> outgoingUrl;
    //当前页面的内容
    String content;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<String> getOutgoingUrl() {
        return outgoingUrl;
    }

    public void setOutgoingUrl(Set<String> outgoingUrl) {
        this.outgoingUrl = outgoingUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
