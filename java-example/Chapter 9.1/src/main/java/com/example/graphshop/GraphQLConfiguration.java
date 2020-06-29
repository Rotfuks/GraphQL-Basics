package com.example.graphshop;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;

@Configuration
public class GraphQLConfiguration {

    @Bean
    public GraphQLScalarType addScalarGraphQLDate() {
        return GraphQLScalarType.newScalar()
                .name("GraphQLDate")
                .description("Date Type")
                .coercing(new Coercing<LocalDate, String>() {
                    @Override
                    public String serialize(Object input) {
                        try {
                            String dateStr = String.valueOf(input);
                            LocalDate.parse(dateStr);
                            return dateStr;
                        } catch (DateTimeParseException e) {
                            throw new CoercingSerializeException(
                                    "Invalid value '" + input + "' for GraphQLDate");
                        }
                    }

                    @Override
                    public LocalDate parseValue(Object input) {
                        try {
                            String dateStr = String.valueOf(input);
                            return LocalDate.parse(dateStr);
                        } catch (DateTimeParseException e) {
                            throw new CoercingParseValueException(
                                    "Invalid value '" + input + "' for GraphQLDate");
                        }
                    }

                    @Override
                    public LocalDate parseLiteral(Object input) {
                        try {
                            if (!(input instanceof StringValue)) return null;
                            String value = ((StringValue) input).getValue();
                            return LocalDate.parse(value);
                        } catch (DateTimeParseException e) {
                            throw new CoercingParseValueException(
                                    "Invalid literal '" + input + "' for GraphQLDate");
                        }
                    }
                })
                .build();
    }
}
