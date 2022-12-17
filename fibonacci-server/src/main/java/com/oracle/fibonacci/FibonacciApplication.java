package com.oracle.fibonacci;

import com.oracle.fibonacci.config.DropWizardConfiguration;
import com.oracle.fibonacci.health.ApplicationHealthCheck;
import com.oracle.fibonacci.resources.FibonacciResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class FibonacciApplication extends Application<DropWizardConfiguration> {

    public static void main(String[] args) throws Exception {
        new FibonacciApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard";
    }

    @Override
    public void initialize(Bootstrap<DropWizardConfiguration> bootstrap) {
    }

    @Override
    public void run(DropWizardConfiguration configuration,
                    Environment environment) {
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.setInitParameter(CrossOriginFilter.CHAIN_PREFLIGHT_PARAM, Boolean.FALSE.toString());
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        final FibonacciResource resource = new FibonacciResource();
        final ApplicationHealthCheck healthCheck =
                new ApplicationHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);


    }
}
