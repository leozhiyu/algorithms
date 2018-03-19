/**
 * @author:Leo
 * @create 2018/3/19
 * @desc
 * 链表实现队列
 */
package fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public class LinkedQueue<T> implements Iterable<T>{
    /**头结点*/
    private Node first;
    /**尾结点*/
    private Node last;
    /**队列大小*/
    private int N;



    /**
     * 链表结点
     */
    private class Node {
        private T item;
        private Node next;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 返回队列的大小
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 向队列中添加元素
     * @param item
     */
    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        }else {
            oldLast.next = last;
        }
        N++;
    }

    /**
     * 出队列
     * @return
     */
    public T dequeue() {
        T item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    /**
     * 迭代器实现
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node it = first;
            @Override
            public boolean hasNext() {
                return it != null;
            }

            @Override
            public T next() {
                T item = it.item;
                it = it.next;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        String[] strArr = "to be or not to - be - - that - - - is".split(" ");

        LinkedQueue<String> linkedQueue = new LinkedQueue();
        for (int i = 0; i < strArr.length; i++){
            if (!strArr[i].equals("-")){
                linkedQueue.enqueue(strArr[i]);
            }else {
                System.out.print(linkedQueue.dequeue() + " ");
            }
        }
        System.out.println();
        System.out.println(linkedQueue.size() + " left on stack()");

        for (String s : linkedQueue) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : linkedQueue) {
            System.out.print(s + " ");
        }

        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
    }
}
