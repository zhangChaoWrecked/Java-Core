package com.puzzle.collection.array;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/23 0023.
 */
public class DrawNameFromArray {     //随即从数组中抽签


    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");

        System.out.println(list);


        while (!list.isEmpty()) {
            long index = Math.round(Math.floor(Math.random() * list.size()));
            System.out.println("Name " + list.get((int) index));
            list.remove((int) index);
        }

    }
}
