package basic.day18.IO.mldn_io;

/**实例操作二：菜单显示
 * XXX系统
 * ［1］增加数据
 * ［2］删除数据
 * ［3］修改数据
 * ［4］查看数据
 * ［0］系统退出
 * 如果用户输入的编号不正确，则要给出错误提示，并等待用户重新选择。
 * 菜单类调用操作类，而具体的实际操作由操作类完成。
 */
/*
 * 操作类的代码比较简单，因为程序本身的功能要求只是实现菜单，如果完成具体的操作，
 * 直接修改此类即可。
 */
public class Operate {
	public static void add(){	//增加操作
		System.out.println("**选择的是增加操作");
	}
	public static void delete(){	//删除操作
		System.out.println("**选择的是删除操作");
	}
	public static void update(){	//修改操作
		System.out.println("**选择的是更新操作");
	}
	public static void find(){	//查看操作
		System.out.println("**选择的是查看操作");
	}
}
