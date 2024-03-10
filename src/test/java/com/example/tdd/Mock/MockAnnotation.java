package com.example.tdd.Mock;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class MockAnnotation {

    @Mock
    UserService userService;

    @Test
    void testReferenceType() {
        assertNull(userService.getUser());
    }

    @Test
    void testPrimitiveType() {
        assertEquals(0, userService.getLoginErrNum());
    }
}
