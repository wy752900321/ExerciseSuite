package basic.day08.snake;

public class WormPane {
	private Worm worm;

	private int rows = 10;// 行数

	private int cols = 32;// 列数

	public Worm getWorm() {
		return worm;
	}

	public void setWorm(Worm worm) {
		this.worm = worm;
	}
	// 创建面板
	public WormPane(){
		worm = new Worm();//创建一条默认的蛇
	}
	//画出当前面板
	public void print(){
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(i==0||i==rows-1){
					System.out.print("-");//不能输出回车
				}else if(j==0||j==cols-1){
					System.out.print("|");
				}else if(worm.contain(i, j)){
					System.out.print("#");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();//一行结束以后画回车
		}
	}
}
