package coll_que;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		
		
		Queue<String> pq = new PriorityQueue<>();
		
		pq.add("Core Java");
		pq.add("React");
		pq.add("HTML");
		pq.add("Angular");
		
		System.out.println(pq);
		
		pq.remove("Angular"); //if you give remove method it will check the queue, if the queue is empty it will throw exception - NoSuchElementException
		
		System.out.println("After Remove: "+ pq);
		
		System.out.println("Poll method: "+pq.poll()); // if the queue is empty, it will give the result as null
		
		System.out.println("Final Queue: "+ pq);
		
		System.out.println(pq.peek());
		
	}

}
