package com.oracle.fibonacci.resources;

import com.codahale.metrics.annotation.Timed;
import com.oracle.fibonacci.api.Sequence;
import com.oracle.fibonacci.util.Calculator;
import io.dropwizard.jersey.params.IntParam;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("fibonacci")
@Produces(MediaType.APPLICATION_JSON)
public class FibonacciResource {

    public FibonacciResource() {
    }

    @GET
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Sequence getPayload(@QueryParam("elements") @NotNull @Min(1) @Max(100) IntParam num) {
        return Calculator.getFibonacci(num.get());
    }
}