package com.jiemeng.utils;

import com.jiemeng.entity.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;

public class HtmlParseUtil {
//    public static void main(String[] args) throws Exception {
//        HtmlParseUtil.parseJD("vue").forEach(content -> {
//            System.out.println(content.toString());
//        });
//    }
    public static ArrayList<Content> parseJD(String keywords) throws Exception {
        String url="https://search.jd.com/Search?keyword="+keywords;
        //解析网页就是浏览器的document对象
        Document document = Jsoup.parse(new URL(url),1000000);
        //所有js里面所用的这里都能用
        Element element = document.getElementById("J_goodsList");
        //获取所有的li标签
        Elements li = element.getElementsByTag("li");
        ArrayList<Content> contents = new ArrayList<>();
        //获取元素中的内容
        for (Element el : li) {
            String image = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price =  el.getElementsByClass("p-price").eq(0).text();
            String title =  el.getElementsByClass("p-name").eq(0).text();
            Content content = new Content();
            content.setImage(image);
            content.setPrice(price);
            content.setTitle(title);
            contents.add(content);
        }
        return contents;
    }
}
