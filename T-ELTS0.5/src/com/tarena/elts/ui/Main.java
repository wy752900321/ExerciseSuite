package com.tarena.elts.ui;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.User;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.ExamServiceImpl;
import com.tarena.elts.service.IdOrPwdException;
import com.tarena.elts.util.Config;

public class Main {
  public static void main(String[] args) {
    //创建所有对象, 注入, 解决依赖关系
    LoginFrame loginFrame = new LoginFrame();
    MenuFrame menuFrame = new MenuFrame();
    ExamFrame examFrame = new ExamFrame();
    WelcomeWindow welcomeWindow = new WelcomeWindow();
    ClientContext clientContext = new ClientContext();
//    ExamService examService = new ExamService(){
//      public User login(int id, String pwd) throws IdOrPwdException {
//        if(id==1 && pwd.equals("1234")){
//          return new User("Robin", 1, "1234");
//        }
//        throw new IdOrPwdException("登录错误!");
//      } 
//    };
//    
    ExamServiceImpl examService = new ExamServiceImpl();
    Config config = new Config("client.properties");
    EntityContext entityContext = new EntityContext(config);
    
    examService.setEntityContext(entityContext);
    
    clientContext.setExamService(examService);
    clientContext.setLoginFrame(loginFrame);
    clientContext.setMenuFrame(menuFrame);
    clientContext.setExamFrame(examFrame);
    clientContext.setWelcomeWindow(welcomeWindow);
    
    loginFrame.setClientContext(clientContext);
    
    menuFrame.setClientContext(clientContext);
    
    examFrame.setClientContext(clientContext);
    
    //使用show()显示登录界面
    clientContext.show();
  }

}
