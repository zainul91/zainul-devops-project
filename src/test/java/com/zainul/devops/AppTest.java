package com.zainul.devops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void testApplicationMessage() {
        String message = "Hello Zainul - DevOps Project";

        assertEquals("Hello Zainul - DevOps Project", message);
    }
}
