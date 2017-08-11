package com.cenrise.sample2;
// @author AYUSH

import java.io.File;
import java.io.IOException;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DomMethods {
    public static void main(String[] args) throws IOException{
        
        File input=new File("C:\\Users\\AYUSH\\Desktop\\Jsoup HTML parser - Tutorial & examples.html");
        Document doc=Jsoup.parse(input,"UTF-8","http://aboullaite.me/jsoup-html-parser-tutorial-examples/" );
        
        Element content=doc.getElementById("content");
        Elements links=doc.getElementsByTag("a");
               
        for(Element link:links){
            String linkHref=link.attr("href");
            String linkText=link.text();
            
            System.out.printf("\n%s\n%s\n\n",linkHref,linkText);
        }
    }
}