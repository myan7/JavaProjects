package com.myjobhunting;
// https://leetcode.com/problems/implement-stack-using-queues/

import java.util.*;

/*
Notes:
    You must use only standard operations of a queue,
    which means that only
    push to back,
    peek/pop from front,
    size
    and is empty operations are valid.

    Depending on your language,
    the queue may not be supported natively.
    You may simulate a queue using a list or deque (double-ended queue)
    as long as you use only a queue's standard operations.

Constraints:
    1 <= x <= 9
    At most 100 calls will be made to push, pop, top, and empty.
    All the calls to pop and top are valid.

 */
public class EASY_225_ImplementStackusingQueues {
}

class MyStack0 {
    private Deque<Integer> dq ;

    public MyStack0() {
        this.dq = new ArrayDeque<>();
    }

    public void push(int x) {
        dq.addLast(x);
    }

    public int pop() {
        int last = dq.getLast();
        dq.removeLast();
        return last;
    }

    public int top() {
        return dq.getLast();
    }

    public boolean empty() {
        return dq.isEmpty();
    }
}


// Queue is last in first out.
// Stack is first in first out.
/*
Stack is LIFO (last in - first out) data structure,
in which elements are added and removed from the same end, called top.
In general stack is implemented using array or linked list,
but in the current article we will review a different approach for implementing stack using queues.

In contrast, queue is FIFO (first in - first out) data structure,
in which elements are added only from the one side - rear and removed from the other - front.
In order to implement stack using queues,
we need to maintain two queues q1 and q2. Also we will keep top stack element in a constant memory.
 */
class MyStack {
    private Queue<Integer> q1 ;
    private Queue<Integer> q2;
    int top;

    public MyStack() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
        top = x;
    }
    // you cannot use removeFirst() because the type of q1 is Queue, only queue functions can be used.
    public int pop() {
        while(q1.size() > 1)
        {
            top = q1.peek();
            q2.add(q1.remove());
        }
        int ans = q1.remove();
        Queue<Integer> tmp = q2;
        q2 = q1;
        q1 = tmp; //keep the rest elements in q1.
        return ans;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
