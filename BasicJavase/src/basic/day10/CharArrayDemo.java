package basic.day10;

import java.util.Arrays;

public class CharArrayDemo {

	public static void main(String[] args) {
		int[] ary = {65,66,67};
		char[] chs = {65,66,67};
		//下面两个不同，多态。具体是下面的println()方法重载了
		System.out.println(ary);//[I@42e816，当object输出，调用toString()
		System.out.println(Arrays.toString(ary));//[65, 66, 67]
		System.out.println(chs);//ABC，碰到字符数组，按字符串输出
		
		//char[] VS String
		char[] chs1 ={'北','京'};
		char[] chs2 = {'达','内','科','技'};
		char[] chs3 = 
			Arrays.copyOf(chs1, chs1.length+chs2.length);
			//chs3={'北','京','0','0','0','0'};
		System.arraycopy(chs2, 0, chs3, chs1.length, chs2.length);
			System.out.println(chs3);//北京达内科技
			
			String s1 = "北京";
			String s2 = "达内科技";
			String s3 = s1.concat(s2);//连接
			System.out.println(s3);//北京达内科技
		
			//toUpperCase()原理：
			char[] chs4 = {'A','a','B','b','C','c'};
			char[] chs5 = Arrays.copyOf(chs4, chs4.length);
			for(int i=0;i<chs5.length;i++){
				char ch = chs5[i];
				if(ch>='a' && ch<='z'){
					//X-x='A'-'a'=>X=x+('A'-'a')
					chs5[i] =(char)(ch + ('A'-'a'));
				}
			}
			System.out.println(chs5);//AABBCC
			
			String s4 = "AaBcCc";
			String s5 = s4.toUpperCase();
			System.out.println(s5);//AABBCC
			
			//indexOf()原理：
			char[] chs6 = {'a','b','c','d','e','g','f'};
			char key ='d';
			int j=-1;
			for(int i=0;i<chs6.length;i++){
				if(chs6[i]==key){
					j=i;
					break;
				}
			}
			System.out.println(j);
			
			String s6 = "abcdegf";
			int index = s6.indexOf('d');
			System.out.println(index);//3,看元素在哪个位置
		}
	}

