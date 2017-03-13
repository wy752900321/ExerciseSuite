package basic.day11;

import java.util.Arrays;

/**
 	StringBuilder人工作原理
 * */
public class StringBuilderDemo {
public static void main(String[] args) {
	//new StringBuilder()
	char[] chs = new char[5];
	int length=0;//代表chs数组中的有效字符数量
	//追加“北京”。StringBuilder().append()
	chs[length++]='北';
	chs[length++]='京';
	//追加“达内科技",如果容量不够，需要成倍扩容StringBuilder().append()
	chs = Arrays.copyOf(chs, chs.length*2);
	chs[length++]='达';
	chs[length++]='内';
	chs[length++]='科';
	chs[length++]='技';
	//插入“中国”在北京之前,移动“北京达内科技insert()
	chs[7] = chs[5];//移动‘技’
	chs[6] = chs[4];
	chs[5] = chs[3];
	chs[4] = chs[2];
	chs[3] = chs[1];
	chs[2] = chs[0];
	chs[0]='中';
	chs[1]='国';
	length+=2;
	//输出：(StringBuilder toString())
	System.out.println(Arrays.copyOf(chs, length));
	
	//String  char[] + 操作
	//String 是不变的字符串，char[]数组内容不可变，任何操作
	//一旦结果与原字符串内容不同，就复制char[]创建新的字符串对象
	//原String对象不变(char[]数组内容永远不变！)
	//String应用：基本的数据交互，输入输出
	
	//StringBuilder=char[]+对数组内容的操作
	//StringBuilder是彩数组算法维护的char数组,必要时候扩容
	//StringBuilder是对同一个char数组内容进行维护，是内容可变的字符串
	//StringBuilder应用于：字符串数据的计算（增删改查）
	
	//简单说：StringBuilder的（方法操作）性能好于String
	
	//工作中：为了”追求极致“的字符串操作性能使用：char[]+算法
	//			大多的”字符串计算“使用:StringBuilder
	//			String使用在大多数的场合
	StringBuilder buf = new StringBuilder();
	buf.append("北京");
	buf.append("达内科技");
	buf.insert(0, "中国");
	System.out.println(buf.toString());
	}
}
