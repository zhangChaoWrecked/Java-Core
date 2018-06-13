package com.puzzle.collection.comparator;

import java.util.*;

/**
 * Created by Administrator on 2018/4/23 0023.
 */
public class BackwardSort {
    public static void main(String args[]) {
        Employee emps[] = {new Employee("Finance", "Degree, Debbie"),
                new Employee("Finance", "Grade, Geri"),
                new Employee("Finance", "Extent, Ester"),
                new Employee("Engineering", "Measure, Mary"),
                new Employee("Engineering", "Amount, Anastasia"),
                new Employee("Engineering", "Ratio, Ringo"),
                new Employee("Sales", "Stint, Sarah"),
                new Employee("Sales", "Pitch, Paula"),
                new Employee("Support", "Rate, Rhoda"),};
        SortedSet set = new TreeSet(Arrays.asList(emps));
        System.out.println(set);

        try {
            Object last = set.last();
            boolean first = true;
            while (true) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.println(last);
                last = set.headSet(last).last();
            }
        } catch (NoSuchElementException e) {
            System.out.println();
        }

        Set subset = set.headSet(emps[4]);
        subset.add(emps[5]);

    }
}

class EmpComparator implements Comparator {

    public int compare(Object obj1, Object obj2) {
        Employee emp1 = (Employee) obj1;
        Employee emp2 = (Employee) obj2;

        int nameComp = emp1.getName().compareTo(emp2.getName());

        return ((nameComp == 0) ? emp1.getDepartment().compareTo(
                emp2.getDepartment()) : nameComp);
    }
}

class Employee implements Comparable {
    String department, name;

    public Employee(String department, String name) {
        this.department = department;
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "[dept=" + department + ",name=" + name + "]";
    }

    public int compareTo(Object obj) {
        Employee emp = (Employee) obj;
        int deptComp = department.compareTo(emp.getDepartment());

        return ((deptComp == 0) ? name.compareTo(emp.getName()) : deptComp);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee emp = (Employee) obj;
        return department.equals(emp.getDepartment())
                && name.equals(emp.getName());
    }

    public int hashCode() {
        return 31 * department.hashCode() + name.hashCode();
    }
}


