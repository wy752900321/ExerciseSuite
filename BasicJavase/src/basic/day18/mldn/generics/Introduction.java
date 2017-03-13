package basic.day18.mldn.generics;

public class Introduction implements Info9{//实现Info9接口
	private String name;
	private String sex;
	private int age;
	public Introduction(String name, String sex, int age) {
		this.setName(name);
		this.setSex(sex);
		this.setAge(age);
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "基本信息："+"\n"+
		"\t|-姓名："+this.name+"\n"+
		"\t|-性别："+this.sex+"\n"+
		"\t|-年龄："+this.age;//返回对象信息
	}
	
}
