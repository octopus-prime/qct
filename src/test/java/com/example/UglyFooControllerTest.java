package com.example;

import io.quarkus.test.InjectMock;
import io.quarkus.test.component.QuarkusComponentTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@QuarkusComponentTest
class UglyFooControllerTest {

    @Inject
    FooController fooController;

    @InjectMock
    FooRepository fooRepository;

    @InjectMock
    FooMapper fooMapper;

    @InjectMock
    Foo foo;

    @InjectMock
    FooResponse fooResponse;

    @Test
    void getFoo() {
        when(fooRepository.findFoo("1")).thenReturn(foo);
        when(fooMapper.mapFoo(foo)).thenReturn(fooResponse);

        FooResponse result = fooController.getFoo("1");

        assertEquals(fooResponse, result);
    }
}
