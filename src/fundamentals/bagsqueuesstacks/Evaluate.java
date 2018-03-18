/**
 * @author:Leo
 * @create 2018/3/18
 * @desc
 * 字符串表达式解释器
 * 通过输入的字符串所表达的运算，计算的到结果
 *
 * 双栈算术表达式求值算法
 */
package fundamentals.bagsqueuesstacks;

import java.util.Arrays;
import java.util.Stack;

public class Evaluate {
    public static void main(String[] args) {
        String expression = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        String[] expreArray = expression.split(" ");
        int i = 0;
        System.out.println(Arrays.toString(expreArray));
        Stack<String> operation = new Stack<>();
        Stack<Double> values = new Stack<>();
        while (i < expreArray.length) {
            if (expreArray[i].equals("(")) {

            }else if (expreArray[i].equals("+")) {
                operation.push("+");
            }else if (expreArray[i].equals("-")) {
                operation.push("-");
            }else if (expreArray[i].equals("*")) {
                operation.push("*");
            }else if (expreArray[i].equals("/")) {
                operation.push("/");
            }else if (expreArray[i].equals(")")) {
                String op = operation.pop();
                double value = values.pop();
                if (op.equals("+")){
                    value = value + values.pop();
                }else if (op.equals("-")) {
                    value = value - values.pop();
                }else if (op.equals("*")) {
                    value = value * values.pop();
                }else if (op.equals("/")) {
                    value = value / values.pop();
                }
                values.push(value);
            }else {
                values.push(Double.parseDouble(expreArray[i]));
            }
            i++;
        }
        System.out.println(values.pop());
    }
}
