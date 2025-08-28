package com.io.readingweb;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestLombok {
    private String name;

    public static void main(String[] args) {
        TestLombok testLombok = new TestLombok();
        testLombok.setName("Hung");
        System.out.println(testLombok.getName());
    }
}
