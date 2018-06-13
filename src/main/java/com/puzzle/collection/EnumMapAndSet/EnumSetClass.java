package com.puzzle.collection.EnumMapAndSet;

import java.util.EnumSet;
import java.util.Iterator;

/**
 * Created by Administrator on 2018/4/23 0023.
 */
public class EnumSetClass {

    public static void main(String[] args) {
        EnumSet largeSize = EnumSet.of(EnumMapClass.Size.XL, EnumMapClass.Size.XXL, EnumMapClass.Size.XXXL);
        for (Iterator it = largeSize.iterator(); it.hasNext(); ) {
            EnumMapClass.Size size = (EnumMapClass.Size) it.next();
            System.out.println(size);
        }
    }

    enum Size {
        S, M, L, XL, XXL, XXXL;

    }
}
