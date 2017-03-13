package com.tarena.elts.entity;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.tarena.elts.util.Config;

/**
 * 实体数据管理，用来读取数据文件放到内存集合中 5. 装载用户信息到用户集合 , 从文件中加载用户数据到users集合 1)
 * 增加类EntityContext实现数据访问功能
 */
public class EntityContext {

	// 增加类EntityContext实现数据访问功能
	private Config config;

	public EntityContext(Config config){
		this.config = config;
		loadUsers(config.getString("UserFile"));
		loadQuestions(config.getString("QuestionFile"));
		
		// loadQuestions("corejava.txt");
	}

	/** key是用户的ID，value：用户实例 */
	private HashMap<Integer, User> users = new HashMap<Integer, User>();
	/**
	 * key:Level难度级别
	 * Value:是同一级别下全部试题
	 */
	private HashMap<Integer,List<Question>> questions = new HashMap<Integer,List<Question>>();

	public User findUserById(int id) {
		return users.get(id);
	}
	public List<Question> findQuestions(int level){
		return new ArrayList<Question>(questions.get(level));
	}

	/** 从文件中加载用户数据到users集合 */
	private void loadUsers(String filename) {
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(filename), "GBK"));// 打开文件
			String line;// 一行数据，一行一行读取
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.startsWith("#") || line.equals("")) {
					continue;// 忽略空行和注释(#)
				}
				User one = parseUser(line);
				users.put(one.getId(), one);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	 //1002:张三:1234:13810381038:zhangsan@tarena.com.cn
	 //   0    1    2           3                      4
	private User parseUser(String line) {
		String[] data = line.split(":");
		User user = new User();
		user.setId(Integer.parseInt(data[0]));
		user.setName(data[1]);
		user.setPasswd(data[2]);
		user.setPhone(data[3]);
		user.setEmail(data[4]);
		return user;
	}
	
	/**解析试题文件，到questions集合中*/
	private void loadQuestions(String file){
		try{
			BufferedReader in = 
				new BufferedReader(
						new InputStreamReader(
								new BufferedInputStream(
										new FileInputStream(file)),"gbk"));
			String str;
			while((str=in.readLine())!=null){
				str = str.trim();
				if(str.equals("")||str.startsWith("#")){
					continue;
				}
				//解析流信息到Question对象
				Question q  = parseQuestion(str,in);
				addQuestion(q);//添加到集合
			}
			in.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	private void addQuestion(Question q){
//	    if(questions.containsKey(q.getLevel())){
//      questions.get(q.getLevel()).add(q);
//    }else{
//      List<Question> list = new ArrayList<Question>();
//      list.add(q);
//      questions.put(q.getLevel(), list);
//    }
		List<Question> list = questions.get(q.getLevel());
		if(list==null){
			list=new ArrayList<Question>();
			questions.put(q.getLevel(),list);
		}
		list.add(q);
//		System.out.println("q:"+q);
	    //System.out.println("list:"+list);
	    //System.out.println("questions:"+questions);
	}
	private Question parseQuestion(String str,BufferedReader in) throws IOException{
		String[] data = str.split("[@,][a-z]+=");
		//str: @answer=2/3,score=5,level=5
	    // 以上字符串 切为: 如下结果
	    // data:{"","2/3","5","5"}
		Question q = new Question();
		q.setAnswers(parseAnswer(data[1]));
		q.setScore(Integer.parseInt(data[2]));
		q.setLevel(Integer.parseInt(data[3]));
		q.setTitle(in.readLine());//读取题干
		List<String> options = new ArrayList<String>();
		options.add(in.readLine());//连续读取4个选项
		options.add(in.readLine());
		options.add(in.readLine());
		options.add(in.readLine());
		q.setOptions(options);
		q.setType(q.getAnswers().size()==0?Question.SINGLE_SELECTION:Question.MULTI_SELECTION);
		return q;
	}
	 // answer: "2/3"
	private List<Integer> parseAnswer(String answer){
		List<Integer> list = new ArrayList<Integer>();
		String[] data = answer.split("/");
		for(String s:data){
			list.add(Integer.parseInt(s));
		}
		return list;
	}
	  public int getTimeLimit() {
		    return config.getInt("TimeLimit"); 
		  } 

		  public String getTitle() {
		    return config.getString("PaperTitle"); 
		  }
		  /**测试 方法*/
/*		  public static void main(String[] args) {
			Config config = new Config("client.properties");
			EntityContext context = new EntityContext(config);
			//String userfile = config.getString("UserFile");
		    //context.loadUsers("user.txt");
		    //context.loadUsers(userfile);
			System.out.println(context.users);
			System.out.println(context.questions);
		}*/
		  /** 测试方法 */
//		  public static void main(String[] args) throws Exception { 
//			  EntityContextcontext =new EntityContext();//因为变量是私有 的 context.loadUsers("user.txt");
//		  System.out.println(context.users); }
	 
}
