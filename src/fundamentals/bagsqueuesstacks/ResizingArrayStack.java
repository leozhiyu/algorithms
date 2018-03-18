/**
 * @author:Leo
 * @create 2018/3/18
 * @desc
 * 下压栈（能够动态调整数组大小的实现）
 */
package fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public class ResizingArrayStack<T> implements Iterable<T>{
    /** 保存数组元素 */
    private T[] elements = (T[]) new Object[1];
    /** 有效元素的个数 */
    private int N = 0;

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 获得栈的元素个数
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 重新调整栈的大小
     * @param max
     */
    public void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = elements[i];
        }
        elements = temp;
    }

    /**
     * 向栈中添加元素
     * @param element
     */
    public void push(T element) {
        if (N == elements.length) {
            resize(2 * elements.length);
        }
        elements[N++] = element;
    }

    /**
     * 弹出栈顶元素
     * @return
     */
    public T pop() {
        T element = elements[--N];
        elements[N] = null; // 避免对象游离
        if (N > 0 && N < elements.length / 4){
            resize(elements.length / 2);
        }
        return element;
    }

    /**
     * 迭代器
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int i = N;
            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public T next() {
                return elements[--i];
            }
        };
    }


    public static void main(String[] args) {
        String[] strArr = "to be or not to - be - - that - - - is".split(" ");
        ResizingArrayStack<String> resizingArrayStack = new ResizingArrayStack<>();
        for (int i = 0; i < strArr.length; i++) {
            resizingArrayStack.push(strArr[i]);
        }
        for (String s : resizingArrayStack) {
            System.out.println(s);
        }
    }


}
