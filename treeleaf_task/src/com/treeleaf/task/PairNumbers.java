package com.treeleaf.task;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PairNumbers {
    public static int totalNumberOfPairs(int k, int[] numbers) {
        int totalPairs = 0;

        for (int i = 0; i < numbers.length; i++) {
            int sum = numbers[i] + k;
            if (sum == numbers[numbers.length - (i + 1)]) {
                totalPairs += 1;
            }
        }
        return totalPairs;
    }

    public static void main(String[] args) {
        int[] values = {1, 4, 8, 7, 11, 20};

        System.out.println(totalNumberOfPairs(3, values));
    }
}
