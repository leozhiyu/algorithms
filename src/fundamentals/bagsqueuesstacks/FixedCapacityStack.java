/**
 * @author:Leo
 * @create 2018/3/18
 * @desc
 * 泛型定容栈
 */
package fundamentals.bagsqueuesstacks;

public class FixedCapacityStack<T>{
    private T[] items;
    private int N;

    public FixedCapacityStack(int cap) {
        // items = new T[cap];错误代码，不能 new T
        items = (T[]) new Object[cap];
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 获取数组的有效元素个数
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 调整数组的容量
     * @param maxsize
     */
    public void resize(int maxsize){
        // 创建临时数组
        T[] temp = (T[]) new Object[maxsize];
        // 将数组中的值赋予新数组
        for (int i = 0; i < temp.length; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    /**
     * 向栈中添加元素
     * @param item
     */
    public void push(T item) {
        // 判断栈是否需要扩容
        if (N == items.length){
            resize(2 * items.length);
        }
        items[N++] = item;
    }

    public T pop() {
        T item = items[--N];
        // 避免对象游离，该元素被弹出再也不会被使用了
        items[N] = null;
        if ( N > 0 && N == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    public static void main(String[] args) {

        FixedCapacityStack<String> stack = new FixedCapacityStack<>(100);
        String[] strArr = "to be or not to - be - - that - - - is".split(" ");
        for (String s : strArr){
            if (!s.equals("-")) {
                stack.push(s);
            }else if (!stack.isEmpty()){
                System.out.println(stack.pop());
            }
        }

        System.out.println(stack.size() + " left on stack");
    }
}