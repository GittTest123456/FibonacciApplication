package com.oracle.fibonacci.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Sequence {

    List<Integer> fibonacci;
    List<Integer> sorted;

    public Sequence() {
        // Jackson deserialization
    }

    public Sequence(List<Integer> fibonacci, List<Integer> sorted) {
        this.fibonacci = fibonacci;
        this.sorted = sorted;
    }

    @JsonProperty
    public List<Integer> getFibonacci() {
        return this.fibonacci;
    }

    @JsonProperty
    public List<Integer> getSorted() {
        return this.sorted;
    }
}