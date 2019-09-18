package com.casic.demo;

/**
 * 设计循环队列
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，
 * 我们能使用这些空间去存储新的值。
 * 你的实现应该支持如下操作：
 *   1.MyCircularQueue(k): 构造器，设置队列长度为 k 。
 *   2.Front: 从队首获取元素。如果队列为空，返回 -1 。
 *   3.Rear: 获取队尾元素。如果队列为空，返回 -1 。
 *   4.enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 *   5.deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 *   6.isEmpty(): 检查循环队列是否为空。
 *   7.isFull(): 检查循环队列是否已满。
 * 在循环队列中，我们使用一个数组和两个指针（head 和 tail）。 head 表示队列的起始位置，tail 表示队列的结束位置。
 * @author niugaofeng
 * @version 1.0
 * @ClassName: MyCircularQueue
 * @Description TODO
 * @date 2019-09-17 10:43
 **/
class MyCircularQueue {

    private int[] data;
    private int head;
    private int tail;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = 0;
        }
        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }

    /**
     * 测试
     * @ClassName: MyCircularQueue
     * @author niugaofeng
     * @create 2019-09-18 08:33
     * @version 1.0
     **/
    public static void main(String[] args) {

        MyCircularQueue myCircularQueue=new MyCircularQueue(6);

        //["MyCircularQueue","enQueue","Rear","Rear","deQueue","enQueue","Rear","deQueue","Front","deQueue","deQueue","deQueue"]
        //[[6],[6],[],[],[],[5],[],[],[],[],[],[]]
        //[null,true,6,6,true,true,5,true,-1,false,false,false]
        System.out.println(myCircularQueue.enQueue(6));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(5));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.deQueue());
//        System.out.println(myCircularQueue.enQueue(2));
//        System.out.println(myCircularQueue.enQueue(3));
//        System.out.println(myCircularQueue.enQueue(4));
//        System.out.println(myCircularQueue.Rear());
//        System.out.println(myCircularQueue.isFull());
//        System.out.println(myCircularQueue.deQueue());
//        System.out.println(myCircularQueue.enQueue(4));
//        System.out.println(myCircularQueue.Front());
//        System.out.println(myCircularQueue.Rear());


    }
}

