package com.oracle.fibonacci.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SequenceResponse {

    List<Integer> fibonacci;
    List<Integer> sorted;

    public SequenceResponse() {
        // Jackson deserialization
    }

    public SequenceResponse(List<Integer> fibonacci, List<Integer> sorted) {
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