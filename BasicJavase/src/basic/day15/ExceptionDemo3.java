package basic.day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/** 异常综合练习 */
public class ExceptionDemo3 {
	public static void main(String[] args) {
		AccountManager mgr = new AccountManager();
		Scanner in = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("选择：1注册，2登陆，3查看全部，0离开：");
				String cmd = in.nextLine();
				if (cmd.equals("1")) {
					System.out.println("输入(email pwd):");
					String str = in.nextLine();
					String[] data = str.trim().split("\\s+");
					String email = data[0];
					String pwd = data[1];
					User user = mgr.reg(email, pwd);
					System.out.println("注册成功：" + user);
				} else if ("2".equals(cmd)) {
					System.out.println("输入(email pwd):");
					String str = in.nextLine();
					String[] data = str.trim().split("\\s+");
					String email = data[0];
					String pwd = data[1];
					User user = mgr.login(email, pwd);
					System.out.println("登陆成功：" + user);
				} else if ("3".equals(cmd)) {
					List<User> all = mgr.findAll();
					System.out.println("查看成功！");
					// System.out.println(all);
					for (Iterator<User> i = all.iterator(); i.hasNext();) {
						User user = i.next();
						System.out.println(user);
					}
				} else if ("0".equals(cmd)) {
					System.out.println("Bye *_*!");
					break;
				} else {
					System.out.println("命令错误！");
				}
			} catch (EmailExistException e) {
				e.printStackTrace();
				System.out.println("注册失败!" + e.getMessage());
				continue;
			} catch (EmailPwdException e) {
				e.printStackTrace();
				System.out.println("登陆失败！" + e.getMessage());
				continue;
			}
		}
	}
}

/** 帐号管理: 注册, 登录,等 */
class AccountManager {
	private HashMap<String, User> users = new HashMap<String, User>();

	private int index = 1;

	/**
	 * 注册, 条件是: email, pwd, 结果是: 注册成功的用户. 如果email已经被注册过了, 就抛出异常
	 */
	// 注册
	public User reg(String email, String pwd) throws EmailExistException {
		if (users.containsKey(email)) {
			// 在方法中使用throw 抛出异常实例
			throw new EmailExistException("已经注册过了！");
		}
		User user = new User(index++, email, pwd);
		users.put(email, user);
		return user;
	}

	// throws 是用在方法上声明异常的
	// 方法声明了异常, 表示这个方法执行时候可能出异常
	/** 登录系统,条件是: email, pwd, 结果是: 登录成功的用户. */
	public User login(String email, String pwd) throws EmailPwdException {
		User someone = users.get(email);
		if (someone == null) {
			throw new EmailPwdException("查无此人！");
		}
		if (someone.getPwd().equals(pwd)) {
			return someone;// 登陆成功
		}
		throw new EmailPwdException("密码错误！");
	}

	public List<User> findAll() {
		return new ArrayList<User>(users.values());
	}
}

class User {
	private int id;

	private String email;

	private String pwd;

	public User() {
	}

	public User(int id, String email, String pwd) {
		super();
		this.id = id;
		this.email = email;
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public int hashCode() {
		return id;
	}

	public String toString() {
		return id + ":" + email;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (obj instanceof User) {
			User o = (User) obj;
			return this.id == o.id;
		}
		return false;
	}
}

// 自定义异常应该实现全部父类的构造器
class EmailExistException extends Exception {

	public EmailExistException() {
		super();
	}

	public EmailExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailExistException(String message) {
		super(message);
	}

	public EmailExistException(Throwable cause) {
		super(cause);
	}

}

class EmailPwdException extends Exception {

	public EmailPwdException() {
		super();
	}

	public EmailPwdException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailPwdException(String message) {
		super(message);
	}

	public EmailPwdException(Throwable cause) {
		super(cause);
	}

}