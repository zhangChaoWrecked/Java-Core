package com.puzzle.collection.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2018/4/23 0023.
 */
public class SortStudentByMarks {


    public static void main(String[] args) {
        List<Student> al = new ArrayList<>();
        al.add(new Student("Z", 34.34));
        al.add(new Student("M", 123.22));
        al.add(new Student("A", 1378.00));
        al.add(new Student("D", 99.22));
        al.add(new Student("Q", -19.08));
        Collections.sort(al);
        System.out.println(al);
    }

}

class Student implements Comparable<Student> {
    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    String name;
    double grade;

    @Override
    public int compareTo(Student o) {
        if (o == null) {
            return -1;
        }
        int c = Double.valueOf(grade).compareTo(o.grade);
        if (c != 0) {
            return c;
        }
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return String.format("%s has grade %.2f", name, grade);
    }
}