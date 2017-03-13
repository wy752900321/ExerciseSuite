package basic.day04.practice;

import java.util.Scanner;

public class SwitchDate {

	static int year,weekDay;
	public static void main(String[] args) {
		System.out.println("请输入一个年份：");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		year = Integer.parseInt(str);
		weekDay = firstWeekDayOfYear(year);
		System.out.print("\n       "+year+"年 ");
		showMonths();
	}

	public static boolean isLeapYear(int year){//闰年
		return ((year % 4 == 0 && year % 100 !=0)||(year % 400 ==0));
	}
	public static int firstWeekDayOfYear(int year){//计算该年第一天是星期几
		long day = year*365;
		for(int i=1;i<year;i++)
			if(isLeapYear(i))
				day+=1;
		return (int)day%7;
	}
	public static int getMonthOfDays(int month){//获取每个月的天数
		switch(month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			if(isLeapYear(year))
				return 29;
			else
				return 28;
			default:
				return 0;
						
		}
	}
	public static void showMonths(){		//呈现该年的12个月中的所有日期
		for(int m=1;m<=12;m++){
			System.out.println(m+"月");
			System.out.println("Sunday Monday Tuesday Wednesday Thursday Friday Saturday");//每的月的星期数
		
		for(int j=1;j<=weekDay;j++){	//按每个月第一天是星期几打印相应的空格
			System.out.println("       ");
		}
		int monthDay = getMonthOfDays(m);	//获取每个月的天数
		for(int d = 1;d<=monthDay;d++){  //将每个月的天数以一周七天的形式打印出来
			if(d<10)
				System.out.println(" " + "0"+d+"    ");
			else
				System.out.print(" "+d+"  ");
			weekDay = (weekDay + 1)%7; 	//判断当天的第二天是星期几
			if(weekDay==0)		//如果第二天是星期天，便换行
				System.out.println();
		}
		System.out.println();
	}
  }
}
