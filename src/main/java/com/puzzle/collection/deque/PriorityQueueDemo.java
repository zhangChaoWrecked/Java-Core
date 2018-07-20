package com.puzzle.collection.deque;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

//优先级队列  底层数组形式的最小堆

//    1.最小堆是一个完全二叉树，所谓的完全二叉树是一种没有空节点的二叉树。
//    2.最小堆的完全二叉树有一个特性是根节点必定是最小节点，子女节点一定大于其父节点。还有一个特性是叶子节点数量=全部非叶子节点数量+1
//    3.在 PriorityQueue队列中，基于数组保存了完全二叉树。所以在已知任意一个节点在数组中的位置，就可以通过一个公式推算出其左子树和右子树的下标。
//    4.已知节点下标是i，那么他的左子树是2*i+1，右子树是2*i+2。

public interface PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        boolean offer = priorityQueue.offer("1");

    }
}

////TODO 优先级队列 获取元素下标 进行循环

//    private int indexOf(Object o) {
//        if (o != null) {
//            for (int i = 0; i < size; i++)
//                if (o.equals(queue[i]))
//                    return i;
//        }
//        return -1;
//    }


//TODO 优先级队列 添加元素时调整最小堆源码
//public boolean offer(E e) {
//    if (e == null)
//        throw new NullPointerException();
//    modCount++; 操作变量加1
//    int i = size;
//    if (i >= queue.length) 扩容机制
//        grow(i + 1);
//    size = i + 1;   数组大小加1
//    if (i == 0)
//        queue[0] = e;
//    else
//        siftUp(i, e);  调整节点
//    return true;
//}
//TODO  offer 入队是元素首先进入队列尾，然后和自己的父节点比较，像冒泡一样将该节点冒到合适的位置，即比自己的父亲节点大，比自己的儿子节点小。
//    private void siftUpComparable(int k, E x) {
//        Comparable<? super E> key = (Comparable<? super E>) x;
//        while (k > 0) {
//            int parent = (k - 1) >>> 1;  最后一个节点的父点算法
//            Object e = queue[parent];    赋值e代表父节点
//            if (key.compareTo((E) e) >= 0) 传入的节点和父节点比较 如果传入节点Key大于最后一个节点的父节点 则跳出循环 否则 传入的比父节点小调整位置
//                break;
//            queue[k] = e;            传入节点Key小于父节点 调整节点位置 父节点比较大则先放到数组末尾
//            k = parent;              然后这个小标赋值给key进行下一次循环调整节点 直到key大于父节点为止
//        }
//        queue[k] = key;           赋值数组最后一个位置为该传入节点Key
//    }