package PriorityQueue;

import java.util.PriorityQueue;

public class PriorityQueueCode {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(101);
        pq.add(102);
        pq.add(103);
        pq.add(104);

        System.out.println("Head :"+ pq.element());
        System.out.println("Head :"+ pq.peek());
        System.out.println(pq.poll());

        pq.remove();
        System.out.println("after removing two elements");
        System.out.println(pq);
    }
}
