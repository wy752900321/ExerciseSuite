package tts.xml;

import java.util.List;

public class TestBookUtils {
    public static void main(String[] args) throws Exception {
        List<Book> bookList = BookUtils.xmlToBook("");
        for (Book book : bookList) {
            System.out.println(book.getName() + "," + book.getPrice());
        }
    }
}
