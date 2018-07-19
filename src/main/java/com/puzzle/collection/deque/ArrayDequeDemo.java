package com.puzzle.collection.deque;

import java.util.ArrayDeque;

/**
 * Created by Administrator on 2018/7/19 0019.
 */
public interface ArrayDequeDemo {

    public static void main(String[] args) {
        //默认容量为8 head指针和Tail指针值为0
        ArrayDeque<Object> arrayDeque = new ArrayDeque<>(3);
        //Head指针指向底层数组Length-1  此操作一直length-1
        arrayDeque.addFirst("1");
        //Tail指针指向底层数组1        此操作在储存操作做完才tail++
        arrayDeque.addLast("2");
        //以上两个操作如果head==tail则进行扩容一倍  扩容机制 head为0 tail为原数组的length
        //直接获取Head值所在下标元素
        Object first = arrayDeque.getFirst();
        //此操作tail-1 获取最后一个元素  tail总是指向下一个可以插入的空位
        Object last = arrayDeque.getLast();
        //Head指针 +1
        Object pollFirst = arrayDeque.pollFirst();
        //Tail指针 -1
        Object pollLast = arrayDeque.pollLast();
    }
}

