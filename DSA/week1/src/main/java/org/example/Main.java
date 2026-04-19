package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Integer[] prices = new Integer[3];

        prices[0] = 7; // 7
        prices[2] = 6; // 5
        for (Integer price: prices){
            System.out.println(price);

        }
        prices[0] = 3;
        for (Integer price: prices){
            System.out.println(price);

        }



        List<Integer> pricesArrayList = new ArrayList<>(Arrays.asList(prices));
        pricesArrayList.add(5);

        System.out.println(pricesArrayList); //[7, 1, 5, 3, 6, 4, 5]
    }
}