package json;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**在ajax中日期的处理，json
 * step1,先写一个日期转换器类，必须实现JsonValueProcessor接口
 * @author soft01
 *
 */
public class DateProcessor implements JsonValueProcessor{
	
	private String pattern = "yyyy-MM-dd";
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
		
	@Override
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		Date date = (Date)arg0;//得到的是对象，转换成日期
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);//把自己定的格式类型传进来 
		return sdf.format(date);
	}

	@Override
	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		Date date = (Date)arg1;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
}
