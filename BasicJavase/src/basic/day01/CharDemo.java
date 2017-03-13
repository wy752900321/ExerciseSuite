package basic.day01;

public class CharDemo {

	/**
	 *字符类型
	 */
	public static void main(String[] args) {
		char c = 20013;//char c ='中';
		System.out.println(c);//中
		System.out.println((int)c);//20013
		char t ='贾';
		System.out.println(t);//贾
		System.out.println(Integer.toHexString(c));//4e2d
		c = 0x41;//0100 0001
		System.out.println(c);//A
		System.out.println((int)'田');//30000
		System.out.println((int)c);//65
		c = 0xfff0;
		System.out.println(c);//?,不是所有字符都可以显示的
		System.out.println("A~Z的字符值如下：");
		System.out.println((int)'A');//65
		System.out.println((int)'B');//66
		System.out.println((int)'C');//67
		System.out.println((int)'D');//68
		System.out.println((int)'E');//69
		System.out.println((int)'F');//70
		System.out.println((int)'G');//71
		System.out.println((int)'H');//72
		System.out.println((int)'I');//73
		System.out.println((int)'J');//74
		System.out.println((int)'K');//75
		System.out.println((int)'L');//76
		System.out.println((int)'M');//77
		System.out.println((int)'N');//78
		System.out.println((int)'O');//79
		System.out.println((int)'P');//80
		System.out.println((int)'Q');//81
		System.out.println((int)'R');//82
		System.out.println((int)'S');//83
		System.out.println((int)'T');//84
		System.out.println((int)'U');//85
		System.out.println((int)'V');//86
		System.out.println((int)'W');//87
		System.out.println((int)'X');//88
		System.out.println((int)'Y');//89
		System.out.println((int)'Z');//90
		System.out.println("a~z的字符值如下：");
		System.out.println((int)'a');//97
		System.out.println((int)'b');//98
		System.out.println((int)'c');//99
		System.out.println((int)'d');//100
		System.out.println((int)'e');//101
		System.out.println((int)'f');//102
		System.out.println((int)'g');//103
		System.out.println((int)'h');//104
		System.out.println((int)'i');//105
		System.out.println((int)'g');//106
		System.out.println((int)'k');//107
		System.out.println((int)'l');//108
		System.out.println((int)'m');//109
		System.out.println((int)'n');//110
		System.out.println((int)'o');//111
		System.out.println((int)'p');//112
		System.out.println((int)'q');//113
		System.out.println((int)'r');//114
		System.out.println((int)'s');//115
		System.out.println((int)'t');//116
		System.out.println((int)'u');//117
		System.out.println((int)'v');//118
		System.out.println((int)'w');//119
		System.out.println((int)'x');//120
		System.out.println((int)'y');//121
		System.out.println((int)'z');//122
		System.out.println("输出0～10如下：");
		System.out.println((int)'0');//48
		System.out.println((int)'1');//49
		System.out.println((int)'2');//50
		System.out.println((int)'3');//51
		System.out.println((int)'4');//52
		System.out.println((int)'5');//53
		System.out.println((int)'6');//54
		System.out.println((int)'7');//55
		System.out.println((int)'8');//56
		System.out.println((int)'9');//57
//		System.out.println((int)'10');//Invalid character constant！无效的字符常量
		
		char ch = '0'+1;
		System.out.println(ch);//'1'
		System.out.println((int)ch);//48+1=49
		ch = '8';
		System.out.println(ch-'0');//56-48=8
	}
}
