package com.cenrise.sample2;

// @author AYUSH

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class ExtractAtrib {
    
    public static void main(String[] args) {
        //html code string
        String html="<p>An <a href='http://example.com/'><b>example</b></a> link</p>";
        //parsing or extracting content from string in document
        Document doc=Jsoup.parse(html);             //Content in document: <html><head></head><body><p>An <a href="http://example.com/"><b>example</b></a> link.</p></body></html>
        //extract only the first a tag
        Element link=doc.select("a").first();       //link: <a href="http://example.com/"><b>example</b></a>
        
        String text=doc.body().text();              //An example link
        String linkHref=link.attr("href");          //http://example.com/
        String linkText=link.text();                //example
        
        String linkOuterH=link.outerHtml();         //<a href="http://example.com/"><b>example</b></a>
        String linkInnerH=link.html();              //<b>example</b>
        
        
        
    }
}
