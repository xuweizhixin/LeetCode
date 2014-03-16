package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class wordladder {

	public static void main(String[] args) {

        Queue<String> qe=new LinkedList<String>();

        qe.add("b");
        qe.add("a");
        qe.add("c");
        qe.add("e");
        qe.add("d");



        System.out.println("Initial Size of Queue :"+qe.size());


        // get value and does not remove element from queue
        System.out.println("Queue peek :"+qe.peek());

        // get first value and remove that object from queue
        System.out.println("Queue poll :"+qe.poll());


        System.out.println("Final Size of Queue :"+qe.size());
    }
}
