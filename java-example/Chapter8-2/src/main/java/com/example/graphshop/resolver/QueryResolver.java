package com.example.graphshop.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Service;

@Service
public class QueryResolver implements GraphQLQueryResolver {

    public String customer() {
        return "Luke Skywalker";
    }
}