package com.test.customer;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerApplication.class)
public abstract class BaseClass {

    @Autowired
    private CustomerController controller;

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(controller);
    }
}
