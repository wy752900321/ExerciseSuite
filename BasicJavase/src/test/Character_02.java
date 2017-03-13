package test;

/**
 * 搜索字符串indexOf()	lastIndexOf()
 */
public class Character_02 {
public static void main(String[] args) {
	String in = "jiadongpo";
	int index = 0;
	index = in.indexOf('a');
	System.out.println(index);//2
	index = in.lastIndexOf('o');
	System.out.println(index);//8
	index = in.indexOf('o',3);
	System.out.println(index);//4
	
	//找到时第一个‘a'出现之后的首个'b'的位置
	int aIndex = -1;		//Position of first 'a'
	int bIndex = -1;		//Position of first 'o' after 'a'
	aIndex = in.indexOf('a');//Find first 'a'
	if(aIndex>=0){	//Make sure you found 'a'
		bIndex=in.indexOf('o', ++aIndex);//Find first 'o' after first 'a'.
	}
	
	//可以使用indexOf()记录某个特定字符在一个字符串中出现的次数
	aIndex = -1;
	int count = 0;
	while((aIndex=in.indexOf('a',++aIndex))>-1){
		++count;
	}
	System.out.println(count);//1
	
}
}