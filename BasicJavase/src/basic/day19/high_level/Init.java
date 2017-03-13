package basic.day19.high_level;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**结合属性文件的工厂模式
 * 通过属性文件的形式配置所要的子类信息
 * 此类主要功能是取得属性文件的配置信息，如果属性文件不存在，则创建一个新的，并设置默认值
 */
class Init {		//定义初始化操作类
	public static Properties getPro(){
		Properties pro = new Properties();//实例化属性类
		File f = new File("basic.day19.high_level.fruit.properties");
		try{
			if(f.exists()){//属性文件 中已存在
				pro.load(new FileInputStream(f));//读取属性
			}else{//建立一个新的属性文件，同时设置好默认内容
				pro.setProperty("apple", "basic.day19.high_level.factorydemo02.Apple");
				pro.setProperty("orange", "basic.day19.high_level.factorydemo02.Orange");
				pro.store(new FileOutputStream(f), "FRUIT CLASS");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pro;
	}
}
