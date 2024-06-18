package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FooController {

    @Inject
    FooRepository fooRepository;

    @Inject
    FooMapper fooMapper;

    public FooResponse getFoo(String id) {
        Foo foo = fooRepository.findFoo(id);
        return fooMapper.mapFoo(foo);
    }
}
