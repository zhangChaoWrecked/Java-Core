package com.puzzle.collection.comparator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortNameByMark {
    public static void main(String args[]) {
        List<Student> students = new ArrayList<Student>();
        SortByMark sortByMark = new SortByMark();

        students.add(new Student("A", new Double(34.34)));
        students.add(new Student("C", new Double(123.22)));
        students.add(new Student("B", new Double(13.00)));
        students.add(new Student("Z", new Double(99.22)));
        students.add(new Student("X", new Double(-19.08)));

        Collections.sort(students, sortByMark);

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
class SortByMark implements Comparator<Student> {
    @Override
    public int compare(Student studentOne, Student studentTwo) {
        return studentOne.getMark().compareTo(studentTwo.getMark());
    }
}

class Student {
    final Double mark;
    private final String name;

    public Student(String name, Double mark) {
        this.name = name;
        this.mark = mark;
    }

    public Double getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": " + mark;
    }
}