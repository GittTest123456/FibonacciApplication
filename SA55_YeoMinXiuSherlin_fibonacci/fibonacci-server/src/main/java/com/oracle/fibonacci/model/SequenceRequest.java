package com.oracle.fibonacci.model;

import javax.validation.constraints.NotNull;

public class SequenceRequest {

    @NotNull
    private Integer elements;

    public SequenceRequest(){
    }

    public SequenceRequest(Integer elements) {
        this.elements = elements;
    }

    public Integer getElements() {
        return elements;
    }

    public void setElements(Integer elements) {
        this.elements = elements;
    }
}