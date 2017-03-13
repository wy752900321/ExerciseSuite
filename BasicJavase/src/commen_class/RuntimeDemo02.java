package commen_class;

import java.io.IOException;

/**
 *	Runtime类运行本机的可执行程序 
 *以下程序调用本机的记事本程序，记事本程序的执行命令是“notepad.exe"
 */
public class RuntimeDemo02 {
	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
		try {
			run.exec("notepad.exe");//调用本机程序，必须进行异常处理
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
