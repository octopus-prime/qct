package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WorkingFooControllerTest {

    @InjectMocks
    FooController fooController;

    @Mock
    FooRepository fooRepository;

    @Mock
    FooMapper fooMapper;

    @Test
    void getFoo(@Mock Foo foo, @Mock FooResponse fooResponse) {
        when(fooRepository.findFoo("1")).thenReturn(foo);
        when(fooMapper.mapFoo(foo)).thenReturn(fooResponse);

        FooResponse result = fooController.getFoo("1");

        assertThat(result, is(fooResponse));
    }
}
