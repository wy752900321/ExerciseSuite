package basic.day18.mldn.generics;

class Person <T extends Info9>{//此处指定了上限，必须是Info接口的子类
	private T info;//此变量的类型由外部决定

	public Person(T info) {//设置信息属性内容
		this.setInfo(info);
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
	
}
