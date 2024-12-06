/**
 * Configuration class for GraphQL setup.
 * 
 * Purpose:
 * - Adds custom scalars to the GraphQL schema.
 * - Registers the `Date` scalar from `ExtendedScalars` to support date formatting in GraphQL queries and mutations.
 * 
 * Annotations:
 * - @Configuration: Marks this class as a Spring configuration class.
 * - @Bean: Declares the `RuntimeWiringConfigurer` bean for customizing GraphQL wiring.
*/
package edu.unb.tiashack.avocado_api.api.graphql;

import graphql.scalars.ExtendedScalars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQLConfig {

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.Date);
    }
}
