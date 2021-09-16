package com.sadeqtest.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest
//@RunWith(SpringRunner.class)
public class WebLayerTest {
    @Autowired
    private MockMvc mvc;

   // @Test
    public void restException()throws Exception{
        Assertions.assertThrows(Exception.class,()->{mvc.perform(get("/exception"));});
    }
}
