package com.tarena.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


@Controller
@Scope
public class MyAction {
	public MyAction(){
		System.out.println("创建一个MyAction对象");
	}
	public void myinit(){
		System.out.println("将MyAction对象初始化");
	}
	public void mydestroy(){
		System.out.println("将MyAction对象销毁");
	}
	
}	
