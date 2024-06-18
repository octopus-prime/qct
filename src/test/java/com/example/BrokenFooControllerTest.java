package com.example;

import io.quarkus.test.InjectMock;
import io.quarkus.test.component.QuarkusComponentTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@QuarkusComponentTest
class BrokenFooControllerTest {

    @Inject
    FooController fooController;

    @InjectMock
    FooRepository fooRepository;

    @InjectMock
    FooMapper fooMapper;

    @Test
    void getFoo(@InjectMock Foo foo, @InjectMock FooResponse fooResponse) {
        when(fooRepository.findFoo("1")).thenReturn(foo);
        when(fooMapper.mapFoo(foo)).thenReturn(fooResponse);

        FooResponse result = fooController.getFoo("1");

        assertThat(result, is(fooResponse));
    }
}
