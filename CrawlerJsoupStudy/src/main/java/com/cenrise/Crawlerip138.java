package com.cenrise;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by dongpo.jia on 2017/8/11.
 */
public class Crawlerip138 {

    public static void main(String[] args) throws IOException {
        System.out.println(getAreaCodeUseNumber("1375827"));

    }

    public static String getAreaCodeUseNumber(String nmber) throws IOException {
        Document doc = Jsoup.connect("http://www.ip138.com:8080/search.asp?mobile=" + nmber + "&action=mobile").get();
        String strHtml = doc.body().text();
        Elements trs = doc.select("table").select("tr");
        String areaCode = trs.get(5).select("td").get(1).text();
//        table1(doc);
        return areaCode;
    }

    /**
     * 解析表
     *
     * @param doc
     * @return
     */
    private static int tableIterator(Document doc) {
        Elements trs = doc.select("table").select("tr");
        int i;
        for (i = 0; i < trs.size(); i++) {
            Elements tds = trs.get(i).select("td");
            for (int j = 0; j < tds.size(); j++) {
                String txt = tds.get(j).text();
                System.out.println(i + ":" + j);
                System.out.print(txt + " ");
            }
            System.out.println("");
        }
        return i;
    }
}
