package basic.day18.mldn.generics;
/**
 * 定义子类方式2---直接在接口中指定具体类型
 * 与GenericsDemo14.java相关联
 */
interface Info5<T> {
	public T getVar();
}
class InfoImpl2 implements Info5<String>{
	private String var;
	public InfoImpl2(String var){
		this.setVar(var);
	}
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var = var;
	}
	
}