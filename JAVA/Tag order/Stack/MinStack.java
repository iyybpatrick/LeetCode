import java.util.*;
public class MinStack {

	/** initialize your data structure here. */
	Stack<Integer> min;
	Stack<Integer> stack;
    public MinStack() {
    	min = new Stack<>();
    	stack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (!min.isEmpty() && min.peek() < x){
        	min.push(min.peek());
        }else{
        	min.push(x);
        } 	
    }
    
    public void pop() {
        if (!stack.isEmpty()){
        	stack.pop();
        	min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack obj = new MinStack();
		obj.push(-2);
		obj.push(0);
		obj.push(-3);
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
		
	}

}

//question:
	//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
	//
	//push(x) -- Push element x onto stack.
	//pop() -- Removes the element on top of the stack.
	//top() -- Get the top element.
	//getMin() -- Retrieve the minimum element in the stack.
	//Example:
	//MinStack minStack = new MinStack();
	//minStack.push(-2);
	//minStack.push(0);
	//minStack.push(-3);
	//minStack.getMin();   --> Returns -3.
	//minStack.pop();
	//minStack.top();      --> Returns 0.
	//minStack.getMin();   --> Returns -2.