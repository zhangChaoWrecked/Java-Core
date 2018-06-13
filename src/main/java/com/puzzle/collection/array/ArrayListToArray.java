package com.puzzle.collection.array;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/23 0023.
 */
public class ArrayListToArray {

    /**
     * Converts an Integer array list into an double array
     *
     * @param list
     * @return
     */
    final public static double[] integerToDouble(final ArrayList<Integer> list) {

        final double[] returnArray = new double[list.size()];
        int valueIndex = 0;

        for (final Integer value : list) {
            returnArray[valueIndex++] = value;
        }

        return returnArray;
    }

    /**
     * Converts an Integer array list into an float array
     *
     * @param list
     * @return
     */
    final public static float[] integerToFloat(final ArrayList<Integer> list) {

        final float[] returnArray = new float[list.size()];
        int valueIndex = 0;

        for (final Integer value : list) {
            returnArray[valueIndex++] = value;
        }

        return returnArray;
    }

    /**
     * Converts an Float array list into an float array
     *
     * @param list
     * @return
     */
    final public static float[] toFloat(final ArrayList<Float> list) {

        final float[] returnArray = new float[list.size()];
        int valueIndex = 0;

        for (final Float value : list) {
            returnArray[valueIndex++] = value;
        }

        return returnArray;
    }

    /**
     * converts an Integer array list into an int array
     *
     * @param list
     * @return
     */
    final public static int[] toInt(final ArrayList<Integer> list) {

        final int[] returnInt = new int[list.size()];
        int valueIndex = 0;

        for (final Integer value : list) {
            returnInt[valueIndex++] = value;
        }

        return returnInt;
    }

    /**
     * converts an Long array list into a long array
     *
     * @param list
     * @return
     */
    final public static long[] toLong(final ArrayList<Long> list) {

        final long[] returnLong = new long[list.size()];
        int iValue = 0;

        for (final Long value : list) {
            if (value == null) {
                returnLong[iValue++] = -1;
            } else {
                returnLong[iValue++] = value;
            }
        }

        return returnLong;
    }
}
