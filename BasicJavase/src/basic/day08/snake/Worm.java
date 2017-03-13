package basic.day08.snake;

import java.util.LinkedList;

/**
技巧：方向的值分别为 UP=-10、DOWN=10、LEFT=-1、RIGHT=1
	上下值相反，左右值相反
	移动后新坐标的值为（i+dir/10 ， j+dir%10）
*/
public class Worm {
//	蛇身是一个节点（Node）的集合
	private LinkedList<Node> nodes = new LinkedList<Node>();
	private int dir;//当前默认的行走方向
	public static final int UP = -10;
	public static final int DOWN = 10;
	public static final int LEFT = -1;
	public static final int RIGHT = 1;
	
	//默认的蛇
	public Worm(){
		nodes.add(new Node(3,9));
		nodes.add(new Node(4,9));
		nodes.add(new Node(5,9));
		nodes.add(new Node(5,10));
		nodes.add(new Node(6,11));
		nodes.add(new Node(7,11));
		dir = RIGHT;//默认向右走
	}
	//指定的蛇
	public Worm(LinkedList<Node> nodes){
		this.nodes.clear();
		this.nodes.addAll(nodes);
	}
	//走一步
	public void step(){
		//1。找到头节点
		Node head = nodes.getFirst();//相当于:get(0)
		//2.根据当前方向计算新节点
		int i = head.getI()+dir/10;
		int j = head.getJ()+dir%10;
		head = new Node(i,j);
		//3插入节点到头部
		nodes.addFirst(head);//相当于：add(0,head)
		//4.删除末尾节点
		nodes.removeLast();//相当于remove(nodes.size()-1)
	}
	//换个方向走一步
	public void step(int dir){
		if(this.dir+dir==0){
			throw new RuntimeException("不能掉头行驶！");
		}
		this.dir = dir;
		step();
	}
	public boolean contain(int i,int j){
		return nodes.contains(new Node(i,j));
	}
	@Override
	public String toString(){
		return nodes.toString();
	}
	
}
