package com.myjobhunting;

import java.util.*;

public class EASY_155_MinStack {
    List<Integer> stk = new ArrayList<>();
    public EASY_155_MinStack() {

    }

    public void push(int val) {
        stk.add(val);
    }

    public void pop() {
        stk.remove(stk.size()-1);
    }

    public int top() {
        int ans = stk.get(stk.size()-1);
        return ans;
    }

    public int getMin() {
        List<Integer> temp = new ArrayList<>();
        temp.addAll(stk);
        Collections.sort(temp);
        return temp.get(0);
    }
}

/*
Runtime: 6 ms, faster than 74.64% of Java online submissions for Min Stack.
Memory Usage: 48.4 MB, less than 54.93% of Java online submissions for Min Stack.
 */
class MinStack {
    private Stack<int[]> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty())
        {
            stack.push(new int[]{val,val});
        }
        else
        {
            int currMin = stack.peek()[1];
            stack.push(new int[]{val, Math.min(val,currMin)});
        }

    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}

/* 3ms submission*/
class MinStack3 {
    class Node{
        int min, val;
        Node next;
        public Node(int min, int val){
            this.min=min;
            this.val=val;
        }
    }
    Node top;
    public MinStack3() {

    }

    public void push(int val) {
        if(top==null)top=new Node(val,val);
        else{
            Node tmp=new Node(Math.min(top.min,val),val);
            tmp.next=top;
            top=tmp;
        }
    }

    public void pop() {
        top=top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.min;
    }
}

/* 4 ms submission */
class MinStack4 {
    Deque<Integer>minStack;
    Deque<Integer>s1;

    public MinStack4() {
        minStack = new ArrayDeque<>();
        s1 = new ArrayDeque<>();

    }

    public void push(int val) {
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
        s1.push(val);
    }

    public void pop() {
        Integer val = s1.pop();
        if(val == getMin()){
            minStack.pop();
        }
    }

    public int top() {
        if(! s1.isEmpty()){
            return s1.peek();
        }
        return -1;
    }

    public int getMin() {

        if(minStack.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return minStack.peek();
    }
}
/* 5 ms submission */
class MinStack5 {
    NodeMin head;
    class NodeMin {
        int data;
        int min;
        NodeMin next;
        public NodeMin(int data, int min) {
            this.data = data;
            this.min = head == null ? data : Math.min(data, head.min);
        }
    }

    public void push(int data) {
        if(head == null) head = new NodeMin(data, data);
        else {
            NodeMin curr = new NodeMin(data, Math.min(head.min, data));
            curr.next = head;
            head = curr;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.data;
    }

    public int getMin() {
        return head.min;
    }
}

