package com.puzzle.DES;

import java.io.Serializable;

/**
 * @author ZhangChao
 * @date 2019.01.16  16:23
 */
public class DESEntity implements Serializable {
    private String name;
    private Integer age;

    public DESEntity() {

    }

    public DESEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DESEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
