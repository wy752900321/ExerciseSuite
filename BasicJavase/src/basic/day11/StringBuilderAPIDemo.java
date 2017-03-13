package basic.day11;

public class StringBuilderAPIDemo {
public static void main(String[] args) {
	
	/*append API
	 * if (newcount > value.length)
	    expandCapacity(newcount);
	    
	    int newCapacity = (value.length+1)*2;
	    	if(newCapacity<0){
	    		newCapacity = Integer.MAX_VALUE;
	    	}else if(minimumCapacity>0){
	    		
	    	}
	 */
	StringBuilder buf = new StringBuilder();
	buf.append("李敖先生").append("的前妻").append("胡茵梦")
	.append("据他说，十分漂亮!").delete(2, 4).insert(0, "大师")
	.replace(17, 19, "美丽");
	System.out.println(buf);//buf.toString()
	
	String str = buf.toString();
	System.out.println(str);
	//不好的代码，每行自动创建一个StringBuiler对象
	//java中，String的运算使用StringBuilder()实现
	String s = "a";
	String ss = s+"1"+2+3+4;//java会使用如下计算实现
//	String ss1 = new StringBuilder(s).append("1").append(2)
//				.append(3).append(4).toString();
	//关于java字符串的计算性能优化
	s = "a";
	s+="a";
	s+="a";
	s+="a";
	s+="a";
	///建议优化为：一个StringBuilder对象
	buf	= new StringBuilder(s);
	buf.append("a");
	buf.append("a");
	buf.append("a");
	buf.append("a");
	s = buf.toString();
	System.out.println(s);//aaaaa
	
}
}
