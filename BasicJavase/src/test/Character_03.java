package test;


public class Character_03 {
public static void main(String[] args) {
//	ÌáÈ¡×Ö·û´®subString()
	String str = "zhonghuarenmin";
	String lastword = str.substring(3);
	System.out.println(lastword);//nghuarenmin
	String lastword1 = str.substring(2,4);
	System.out.println(lastword1);//on
	
	//ÇÐ·Ö×Ö·û´® split
	String text = "to be or not to be,that is the question";
	String[] words = text.split("[,]",0);
	System.out.println(words);
}
}
