package com.puzzle.collection.iterator;

import java.util.*;

/**
 * Created by Administrator on 2018/4/23 0023.
 */
public class RandomIterator {
    public static void main(final String[] args) {
        Map<String, String> items;

        items = new HashMap<String, String>();
        items.put("A", "1");
        items.put("B", "2");
        items.put("C", "3");

        display(new RandomIteratorDemo<String>(items.keySet().iterator()));
        display(new RandomIteratorDemo<String>(items.keySet().iterator()));
    }

    private static <T> void display(final Iterator<T> iterator) {
        while (iterator.hasNext()) {
            final T item;
            item = iterator.next();
            System.out.println(item);
        }
    }

    /**
     * Created by Administrator on 2018/4/23 0023.
     */
    static class RandomIteratorDemo<T> implements Iterator<T> {
        private final Iterator<T> iterator;

        public RandomIteratorDemo(final Iterator<T> i) {
            final List<T> items;

            items = new ArrayList<T>();

            while (i.hasNext()) {
                final T item;

                item = i.next();
                items.add(item);
            }

            Collections.shuffle(items);
            iterator = items.iterator();
        }

        public boolean hasNext() {
            return (iterator.hasNext());
        }

        public T next() {
            return (iterator.next());
        }

        public void remove() {
            iterator.remove();
        }
    }
}

