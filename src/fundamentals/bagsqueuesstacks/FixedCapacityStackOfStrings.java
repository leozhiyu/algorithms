/**
 * @author:Leo
 * @create 2018/3/18
 * @desc
 * 定容字符串栈
 */
package fundamentals.bagsqueuesstacks;

public class FixedCapacityStackOfStrings {
    private String[] str;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        str = new String[cap];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void push(String s){
        str[N++] = s;
    }
    public String pop(){
        return str[--N];
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings stackOfStrings = new FixedCapacityStackOfStrings(100);
        String[] strArr = "to be or not to - be - - that - - - is".split(" ");
        for (String s : strArr){
            if (!s.equals("-")) {
                stackOfStrings.push(s);
            }else if (!stackOfStrings.isEmpty()){
                System.out.println(stackOfStrings.pop());
            }
        }
        System.out.println(stackOfStrings.size() + " left on stack");

    }
}
