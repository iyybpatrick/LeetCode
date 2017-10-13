package design;

/**
 * Created by YuebinYang on 10/13/17.
 */
import java.util.*;
public class _155MinStack {
    class MinStack {
        Stack<Integer> minStack;
        Stack<Integer> stack;
        /** initialize your data structure here. */
        public MinStack() {
            minStack = new Stack<>();
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(x);
                minStack.push(x);
            } else {
                if (x < minStack.peek()) {
                    minStack.push(x);
                } else {
                    minStack.push(minStack.peek());
                }
                stack.push(x);
            }
        }

        public void pop() {
            if (!minStack.isEmpty()) {
                minStack.pop();
                stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

}
