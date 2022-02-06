package com.myjobhunting;

import java.util.Stack;

public class EASY_232_ImplementQueueUsingStacks {
}
class MyQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    int head;

    public MyQueue() {
    }

    public void push(int x) {
        if(s1.isEmpty())
            head = x;
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty())
        {
            while (!s1.isEmpty())
            {
                head = s1.peek();
                s2.push(s1.pop());
            }

        }
        int top = s2.pop();
        // restore s1, keeping the pushing order for the next one.
        while(!s2.isEmpty())
        {
            if(s1.isEmpty())
            {
                head = s2.peek();
            }
            s1.push(s2.pop());
        }
        return top;
    }

    public int peek() {
        return head;
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

class MyQueue0 {
    Stack<Integer> stk1 = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();
    int head;

    public MyQueue0() {
    }

    public void push(int x) {
        stk1.push(x);
    }

    public int pop() {
        while(stk1.size() > 1)
        {
            stk2.push(stk1.pop());
        }
        head = stk1.pop();
        while(!stk2.isEmpty())
        {
            stk1.push(stk2.pop());
        }
        return head;
    }

    public int peek() {
        while(stk1.size() > 1)
        {
            stk2.push(stk1.pop());
        }
        head = stk1.peek();
        while(!stk2.isEmpty())
        {
            stk1.push(stk2.pop());
        }
        return head;
    }

    public boolean empty() {
        return stk1.isEmpty();
    }
}
