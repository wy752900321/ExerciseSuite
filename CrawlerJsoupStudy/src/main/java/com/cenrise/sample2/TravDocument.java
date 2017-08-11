package com.cenrise.sample2;
 //@author AYUSH
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;


public class TravDocument {

    public static void main(String[] args) {

        //Parsing and extracting a String from html
        String html="<html><head><title>First Parse</title></head>"+
                "<body><p>Parse HTML into a doc.</p></body></html>";
        
        Document doc=Jsoup.parse(html);
        //Document doc=Jsoup.parse(html,baseURI);   
        //Complete Documennt to string conversion
        System.out.println(doc.text());
        //Title and Body seperatly extracted
        System.out.println(doc.head().text());
        System.out.println(doc.body().text());
        
        //getting contentfrom an URL
        try {
            //establishing a connection. Parsing HTML data in doc
            /*  doc=Jsoup.connect("https://jsoup.org/cookbook/input/load-document-from-url").data("wuery","Java").
                    userAgent("Mozilla").cookie("auth", "token").timeout(3000).post();  */
            
            doc=Jsoup.connect("https://jsoup.org/cookbook/input/load-document-from-url").get();
        } catch (IOException ex) {
            Logger.getLogger(TravDocument.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(doc.text());
        /*System.out.println(doc.head().text());
        System.out.println(doc.body().text());*/
    }
    
}
