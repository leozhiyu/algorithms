/**
 * @author:Leo
 * @create 2018/4/12
 * @desc
 * 二叉树的非递归遍历
 */
package searching.binarysearch;

import java.util.Stack;

public class UnrecursionTraverse {
    /**
     * 创建结点
     */
    public static class Node {
        private int value;
        private Node left;
        private Node right;
        public Node(int data) {
            this.value = data;
        }
    }

    public static void preOrderUnRecusion(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.value + " ");
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    public static void midOrderUnRecusion(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
    }

    public static void aftOrderUnRecurion(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);
            if (head.left != null) {
                stack1.push(head.left);
            }
            if (head.right != null) {
                stack1.push(head.right);
            }
        }
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().value + " ");
        }
    }


    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        System.out.print("先序遍历：");
        preOrderUnRecusion(head);// 先序遍历：5 3 2 1 4 8 7 6 10 9 11
        System.out.print("\n中序遍历：");
        midOrderUnRecusion(head); //中序遍历：1 2 3 4 5 6 7 8 9 10 11
        System.out.print("\n后序遍历：");
        aftOrderUnRecurion(head); // 后序遍历：1 2 4 3 6 7 9 11 10 8 5
    }

}
