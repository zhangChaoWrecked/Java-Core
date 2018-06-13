package com.puzzle.collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Administrator on 2018/4/23 0023.
 */
public class StackQueueUsingArrayDeque {

    public static void main(String args[]) {
        Deque<String> stack = new ArrayDeque<String>();
        Deque<String> queue = new ArrayDeque<String>();

        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");

        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        while (!queue.isEmpty())
            System.out.print(queue.remove() + " ");
    }
}
