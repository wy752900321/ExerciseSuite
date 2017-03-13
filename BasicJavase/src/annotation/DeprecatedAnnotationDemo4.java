package annotation;

/**注：
 *		在设置注释信息时，是以key->value的形式出现的，所以也可以直接使用
 *	"value={"unchecked","deprecation"}"的方式设置
 */
public class DeprecatedAnnotationDemo4 {
//	@SuppressWarnings (value={"unchecked","deprecation"});//此时压制两条警告
	public static void main(String[] args) {
		Demo4 d = new  Demo4();
		d.setVar("贾东坡");
		System.out.println("内容："+d.getVar());
	}
}
@Deprecated
class Demo4<T>{
	public T var;
	public T getVar(){
		return var;
	}
	public void setVar(T var){
		this.var=var;
	}
}