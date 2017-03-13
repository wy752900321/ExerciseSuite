package basic.day03.practice;

public class Test03 {

	/**
	 	The "Hearts" card suit
	 */
	public static final int HEARTS = 1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	/**
	 	Raises the salary of an employee
	 	@param byPercent the percentage by which to 
	 		raise the salary (e.g 10=10%)
	 	@return the amount of the raise
	 */
	public double raiseSalary(double byPercent)
	{
		double salary = 0;
		double raise = salary*byPercent/100;
		salary += raise;
		return raise;
	}

}
