package com.casic.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 队列应支持两种操作：入队和出队。入队会向队列追加一个新元素，而出队会删除第一个元素。
 * @author niugaofeng
 * @version 1.0
 * @ClassName: s
 * @Description TODO
 * @date 2019-09-17 10:22
 **/
public class MyQueue {
    /**
     * store elements
     * @param
     * @return
     **/
    private List<Integer> data;
    /**
     * a pointer to indicate the start position
     * @param
     * @return
     **/
    private int p_start;

    public MyQueue() {
        data = new ArrayList<Integer>();
        p_start = 0;
    }
    /** Insert an element into the queue. Return true if the operation is successful. */
    public boolean enQueue(int x) {
        data.add(x);
        return true;
    };
    /** Delete an element from the queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        p_start++;
        return true;
    }
    /** Get the front item from the queue. */
    public int Front() {
        return data.get(p_start);
    }
    /** Checks whether the queue is empty or not. */
    public boolean isEmpty() {
        return p_start >= data.size();
    }

    public static void main(String[] args) {
//        MyQueue q = new MyQueue();
//        q.enQueue(5);
//        q.enQueue(3);
//        q.enQueue(100);
//        if (q.isEmpty() == false) {
//            System.out.println("-----------");
//            System.out.println(q);
//            System.out.println(q.Front());
//        }
//        System.out.println("**************");
//        q.deQueue();
//        if (q.isEmpty() == false) {
//            System.out.println(q.Front());
//        }
//        System.out.println("**************");
//        q.deQueue();
//        if (q.isEmpty() == false) {
//            System.out.println(q.Front());
//        }

        // 1. Initialize a queue.
        Queue<Integer> q = new LinkedList();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + q.peek());
        // 3. Push new element.
        q.add(33);
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        q.remove();
        // 4. Pop an element.
        q.poll();
        // 5. Get the first element.
        System.out.println("The first element is: " + q.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + q.size());
    }
};
