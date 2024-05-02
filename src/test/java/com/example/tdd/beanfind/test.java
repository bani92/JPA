package com.example.tdd.beanfind;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class test {

    @Test
    public void test2() {
        int[] integerArray = {1234, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list = Arrays.stream(integerArray).boxed().toList();
        System.out.println("list = " + list);

//        Integer findNumber = null;

//        for (int i = 0; i < list.size(); i++) {
//            if(list.get(i).equals(1234)) {
//                findNumber = list.get(i);
//                break;
//            }
//        }
//
//        if (findNumber == null)
//            throw new RuntimeException();

        Integer findNumber = list.stream().filter(integer -> {
                    if (integer.equals(1234)) return true;
                    return false;
                })
                .findAny()
                .orElseThrow();

        System.out.println("findNumber = " + findNumber);
    }
}
