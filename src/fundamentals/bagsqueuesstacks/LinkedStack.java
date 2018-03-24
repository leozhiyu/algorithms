/**
 * @author:Leo
 * @create 2018/3/19
 * @desc
 * 用链表实现栈
 * 头插法
 */
package fundamentals.bagsqueuesstacks;

import java.util.Iterator;
import java.util.Stack;

public class LinkedStack<T> implements Iterable<T> {

    /**
     * 内部类定义结点
     */
    private class Node {
        T item;
        Node next;
    }

    /** 定义头结点 */
    private Node first;
    /** 元素个数 */
    private int N;

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 返回栈的大小
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 入栈
     * @param item
     */
    public void push(T item) {
        //保存原始头结点
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    /**
     * 出栈
     * @return
     */
    public T pop() {
        T item = null;
        if (N != 0) {
            item = first.item;
            first = first.next;
        }
        N--;
        return item;
    }

    /**
     * 实现迭代器
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            // 必须创建该属性，否则直接操作 LinkedStack 中的 first，那么迭代器会改变栈
            private Node it  = first;
            @Override
            public boolean hasNext() {
                // 不能用 N != 0，因为在用迭代器遍历时并没有改变 N 的值
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
        Stack<String> [] a = new Stack[3];
        String[] strArr = "to be or not to - be - - that - - - is".split(" ");
        LinkedStack<String> linkedStack = new LinkedStack();
        for (int i = 0; i < strArr.length; i++){
            if (!strArr[i].equals("-")){
                linkedStack.push(strArr[i]);
            }else {
                System.out.print(linkedStack.pop() + " ");
            }
        }
        System.out.println();
        System.out.println(linkedStack.size() + " left on stack()");

        for (String s : linkedStack) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : linkedStack) {
            System.out.print(s + " ");
        }
    }

}
