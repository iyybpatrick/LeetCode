import java.util.*;
public class MyQueue {

	Stack <Integer> input;
	Stack <Integer> output;
    /** Initialize your data structure here. */
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!output.isEmpty()){
        	input.push(output.pop());
        }
        input.push(x);
        while(!input.isEmpty()){
        	output.push(input.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return output.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return output.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return output.isEmpty();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue obj = new MyQueue();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.empty());
		System.out.println(obj.pop());
		System.out.println(obj.empty());
	}

}

//question:
	//Implement the following operations of a queue using stacks.
	//
	//push(x) -- Push element x to the back of queue.
	//pop() -- Removes the element from in front of queue.
	//peek() -- Get the front element.
	//empty() -- Return whether the queue is empty.
	//Notes:
	//You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
	//Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
	//You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
