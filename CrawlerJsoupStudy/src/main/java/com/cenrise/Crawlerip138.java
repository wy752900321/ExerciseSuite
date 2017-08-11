package com.cenrise;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by dongpo.jia on 2017/8/11.
 */
public class Crawlerip138 {
    static Connection conn;
    static Statement stmt;

    public static void main(String[] args) throws SQLException, IOException {

//        String number = getPhoneNumberSegmentUseNumber("1375827");
        System.out.println("手机号段:" + getPhoneNumberSegmentUseNumber("1375827"));
        System.out.println("卡归属地:" + getCardNumberAttributionUseNumber("1375827"));
        System.out.println("卡类型:" + getCardTypeUseNumber("1375827"));
        System.out.println("区号:" + getAreaCodeUseNumber("1375827"));
        System.out.println("邮编:" + getPostcodeUseNumber("1375827"));

/*
        try {
            conn = DBUtil.openConnection();
            stmt = conn.createStatement();
            int row = stmt.executeUpdate("insert into aa (name) values (number)", Statement.RETURN_GENERATED_KEYS);

        } catch (SQLException e) {
            throw e;
        } finally {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }

        }*/


    }


    /**
     * 获取手机号段
     *
     * @param nmber
     * @return
     * @throws IOException
     */
    public static String getPhoneNumberSegmentUseNumber(String nmber) throws IOException {
        Document doc = Jsoup.connect("http://www.ip138.com:8080/search.asp?mobile=" + nmber + "&action=mobile").get();
        Elements trs = doc.select("table").select("tr");
        String areaCode = trs.get(2).select("td").get(1).text();
        return areaCode;
    }

    /**
     * 获取卡归属地
     *
     * @param nmber
     * @return
     * @throws IOException
     */
    public static String getCardNumberAttributionUseNumber(String nmber) throws IOException {
        Document doc = Jsoup.connect("http://www.ip138.com:8080/search.asp?mobile=" + nmber + "&action=mobile").get();
        Elements trs = doc.select("table").select("tr");
        String areaCode = trs.get(3).select("td").get(1).text();
        return areaCode;
    }

    /**
     * 获取卡类型
     *
     * @param nmber
     * @return
     * @throws IOException
     */
    public static String getCardTypeUseNumber(String nmber) throws IOException {
        Document doc = Jsoup.connect("http://www.ip138.com:8080/search.asp?mobile=" + nmber + "&action=mobile").get();
        String strHtml = doc.body().text();
        Elements trs = doc.select("table").select("tr");
        String areaCode = trs.get(4).select("td").get(1).text();
//        table1(doc);
        return areaCode;
    }

    /**
     * 获取区号
     *
     * @param nmber
     * @return
     * @throws IOException
     */
    public static String getAreaCodeUseNumber(String nmber) throws IOException {
        Document doc = Jsoup.connect("http://www.ip138.com:8080/search.asp?mobile=" + nmber + "&action=mobile").get();
        Elements trs = doc.select("table").select("tr");
        String areaCode = trs.get(5).select("td").get(1).text();
        return areaCode;
    }

    /**
     * 获取邮编
     *
     * @param nmber
     * @return
     * @throws IOException
     */
    public static String getPostcodeUseNumber(String nmber) throws IOException {
        Document doc = Jsoup.connect("http://www.ip138.com:8080/search.asp?mobile=" + nmber + "&action=mobile").get();
        String strHtml = doc.body().text();
        Elements trs = doc.select("table").select("tr");
        String areaCode = trs.get(6).select("td").get(1).text();
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
