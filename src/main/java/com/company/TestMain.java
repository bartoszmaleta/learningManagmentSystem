package com.company;

import com.company.models.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TestMain {
    public static void main(String[] args) {
        ArrayList<String> arrayListObject = new ArrayList<>();

        arrayListObject.add("A");
        arrayListObject.add("B");
        arrayListObject.add("C");
        arrayListObject.add("D");

        System.out.println(arrayListObject);

        ArrayList<String> arrayListClone =  (ArrayList<String>) arrayListObject.clone();

        System.out.println(arrayListClone);

        arrayListClone.set(2, "qwe");
        System.out.println("--------------------");
        System.out.println(arrayListObject);
        System.out.println(arrayListClone);

        System.out.println("--------------------");

        arrayListClone.set(0, "qweqweasdasd");
        System.out.println(arrayListObject);
        System.out.println(arrayListClone);


        List<String> clonedList = arrayListClone.stream().map(String::new).collect(Collectors.toList());

    }
}
