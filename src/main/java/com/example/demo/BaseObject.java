package com.example.demo;

public class BaseObject {
 private Integer id;

public static Integer counter = 0;

public Integer getId() {
    return id;
}
public void assignNewId() {
id = getNextId();
}

public static Integer getNextId() {
    counter ++;
    return counter;
  }
}
