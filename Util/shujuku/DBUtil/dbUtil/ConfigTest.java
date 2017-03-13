package dbUtil;

public class ConfigTest {
	public static void main(String[] args) {
		String path="/dbUtil/db.xml";
		Configuration config=
					Configuration.config(path);
		System.out.println(config);
	}
}
