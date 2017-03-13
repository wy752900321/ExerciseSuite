package basic.day18.IO.mldn_io;

/**
 * 范例：直接使用以上类即可输入数字
 */
public class TestInputData {
	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		InputData input = new InputData();
		i = input.getInt("请输入第一个数字：", "输入的数据必须是数字，请重新输入！");
		j = input.getInt("请输入第二个数字：", "输入的数据必须是数字，请重新输入！");
		System.out.println(i+"+"+j+"="+(i+j));
	}
}
