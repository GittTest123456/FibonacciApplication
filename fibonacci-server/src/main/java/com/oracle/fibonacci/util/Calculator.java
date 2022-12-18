package com.oracle.fibonacci.util;

import com.oracle.fibonacci.model.SequenceResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {

    public static SequenceResponse getFibonacci(Integer num) {
        Stack<Integer> odds = new Stack<>();
        Stack<Integer> evens = new Stack<>();
        List<Integer> sequence = new ArrayList<>();

        sequence.add(0);
        evens.add(0);

        Integer curr_minus_2 = 0;
        Integer curr_minus_1 = 0;
        Integer curr = 1;

        for (int i = 1; i < num; i++) {
            sequence.add(curr);
            if (curr % 2 == 0) {
                evens.add(curr);
            } else {
                odds.add(curr);
            }
            curr_minus_2 = curr_minus_1;
            curr_minus_1 = curr;
            curr = curr_minus_2 + curr_minus_1;
        };
        return new SequenceResponse(sequence, mergeLists(odds, evens));
    }

    private static List<Integer> mergeLists(Stack<Integer> odds, Stack<Integer> evens) {
        List<Integer> merged = new ArrayList<>();
        while (!evens.isEmpty()) {
            merged.add(evens.pop());
        }
        while (!odds.isEmpty()) {
            merged.add(odds.pop());
        }
        return merged;
    }
}
