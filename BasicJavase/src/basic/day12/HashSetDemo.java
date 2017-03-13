package basic.day12;

import java.util.Set;
import java.util.HashSet;

public class HashSetDemo {

	public static void main(String[] args) {
		Set<Node> foods = new HashSet<Node>();
		foods.add(new Node(5,5));
		foods.add(new Node(7,10));
		foods.add(new Node(21,3));
		foods.add(new Node(4,19));
		foods.add(new Node(5,5));
		System.out.println(foods);
		System.out.println(foods.size());
	}

}
class Node{
	int i;
	int j;
	public Node(int i,int j){
		this.i=i;
		this.j=j;
	}
	public String toString(){
		return i+","+j;
	}
	public int hashCode(){
		return i*10000+j;
	}
	public boolean equals(Object obj){
		if(obj==null)
			return false;
		if(this==obj)
			return true;
		if(obj instanceof Node){
			Node other = (Node)obj;
			return this.i == other.i  && this.j ==other.j;
		}
		return false;
	}
}