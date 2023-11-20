package priorityQueue;

import java.util.PriorityQueue;

public class test {
    public static void main(String[] args) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        pQueue.add(3);
        pQueue.add(1);
        pQueue.add(2);
        for (Integer integer : pQueue) {
            System.out.println(integer);
        }
    }
}
