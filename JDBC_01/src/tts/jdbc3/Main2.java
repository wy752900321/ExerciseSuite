package tts.jdbc3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
/*
 * a' or 'c' = 'c作为密码时，登录不成功了。SQL注射问题解决了
 */
public class Main2 {
	public static void main(String[] args) throws Exception {
		UserService userService = new UserService();
//		Scanner br = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br.nextLine();
		br.readLine();
		System.out.println("请输入用户名：");
//		String username = br.nextLine();
		String username = br.readLine();
		System.out.println("请输入密码：");
		String password = br.readLine();
//		String password = br.nextLine();
		
		boolean b = userService.login(username, password);
		
		if(b){
			System.out.println("登录成功！");
		}else{
			System.out.println("登录失败！");
		}
	}
}
