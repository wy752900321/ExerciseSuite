package longtime;
/**
 1.我们将类作为final的
	动态生成机制将失效，延迟加载机制失效，默认为get()方法了。
	因此注意：自定义的类不要做成final的，因为在很多构架中会有这动态生成机制
 */
public class Foo {
	private Integer id;
	private String value;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
