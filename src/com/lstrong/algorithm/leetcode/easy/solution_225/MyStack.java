package com.lstrong.algorithm.leetcode.easy.solution_225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/12/26 12:42<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class MyStack {

    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {

        queue.add(x);
        for (int i = 1 ; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
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
