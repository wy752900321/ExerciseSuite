package container_sumarize_shiyong;

import java.util.ArrayList;
	/**重点：
	 	以下程序模拟java EE处理查询显示功能，先查询数据库，每一条结果
	 	集记录生成一个对象保存进ArrayList集合里，最后生成一个表格。
	 	表格内的每一行是一条记录
	 	
	 	输出：
	 		-------------------
			|姓  名|年龄|地 址|
			|孙悟空|500|花果山|
			|猪八戒|300|高老庄|
			|沙和尚|200|流沙河|
			------------------
	 */
public class TestArrayListDemo2 {
public static void main(String[] args) {
	String[] names = {"孙悟空","猪八戒","沙和尚"};
	int[] ages = {500,300,200};
	String[] addresses = {"花果山","高老庄","流沙河"};
	
	ArrayList userList = new ArrayList();
	for(int i=0;i<3;i++){//如果是数据结果集就是while(rs.next())
		UserBean ub = new UserBean(names[i],ages[i],addresses[i]);
		userList.add(ub);
	}
	
	//将保存后的list对象传入显示层进行显示
	System.out.println("-------------------");
	//显示表头
	System.out.print("|");
	System.out.print("姓  名");
	System.out.print("|");
	System.out.print("年龄");
	System.out.print("|");
	System.out.print("地 址");
	System.out.println("|");
	for(int i=0;i<userList.size();i++){
		UserBean ub = (UserBean)userList.get(i);//强制类型转换
		System.out.print("|");
		System.out.print(ub.getName());
		System.out.print("|");
		System.out.print(ub.getAge());
		System.out.print("|");
		System.out.print(ub.getAddress());
		System.out.println("|");
	}
	System.out.println("------------------");
  }
}
class UserBean{
	private String name;
	private int age ;
	private String address;
	public UserBean(String name,int age,String address){
		this.name = name ;
		this.age = age;
		this.address = address;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
}