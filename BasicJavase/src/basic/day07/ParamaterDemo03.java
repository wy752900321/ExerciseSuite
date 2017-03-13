package basic.day07;

public class ParamaterDemo03 {

	public static void main(String[] args) {
		int a = 1;
		K2oo koo = new K2oo();
		int[] ary = {1};//new int[]{1};
		add(a);
		add(koo);
		add(ary);
		System.out.println(a+" ,"+koo.a);//1,2
		System.out.println(koo);;//basic.day07.practice.Koo@9304b1
	}
	public static int add(int a){
		a++;
		return a;
	}
	public static int add(K2oo koo){
		K2oo k = koo;
		k.a++;
		return koo.a;
	}
	public static int add(int[] ary){
		return ++ary[0];
	}

}
class K2oo{
	int a=1;
}