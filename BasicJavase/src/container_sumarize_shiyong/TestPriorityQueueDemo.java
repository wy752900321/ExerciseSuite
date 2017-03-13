package container_sumarize_shiyong;

import java.util.PriorityQueue;

public class TestPriorityQueueDemo {

	/**Queue接口
 	PriorityQueue实现类
 */
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		//依次向qq加入四个元素
		pq.offer(5);
		pq.offer(8);
		pq.offer(4);
		pq.offer(-8);
		System.out.println(pq);//并不是按进入顺序输出，而是自然排序
		
	}

}
