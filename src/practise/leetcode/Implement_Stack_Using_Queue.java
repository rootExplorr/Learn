package practise.leetcode;

import java.util.LinkedList;
import java.util.Queue;

//Leetcode: 225
public class Implement_Stack_Using_Queue {
	class MyStack {
	    
	    Queue<Integer> queue;
	    
	    /** Initialize your data structure here. */
	    public MyStack() {
	       queue = new LinkedList<Integer>();         
	    }
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	        queue.add(x);
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	        int poppedElement=-1;
	        int n = queue.size();
	        for(int i=1;i<=n;i++){
	            poppedElement = queue.remove();
	            if(i==n)
	                break;
	             queue.add(poppedElement);
	        }
	        return poppedElement;
	    }
	    
	    /** Get the top element. */
	    public int top() {
	        int poppedElement = pop();
	        queue.add(poppedElement);
	        return poppedElement;
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	        return queue.isEmpty();
	    }
	}

	/**
	 * Your MyStack object will be instantiated and called as such:
	 * MyStack obj = new MyStack();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */
}
