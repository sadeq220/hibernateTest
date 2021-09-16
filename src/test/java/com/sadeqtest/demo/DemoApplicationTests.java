package com.sadeqtest.demo;

import com.sadeqtest.demo.controller.MyController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationTest.properties")
class DemoApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private MyController myController;

    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() throws Exception{
        Assertions.assertThat(myController).isNotNull();
        mvc.perform(get("/home").param("name","sadeq")).andDo(print()).andExpect(status().is(200))
                .andExpect(content().string(containsString("{\"bool\":true,\"string\":\"sadeq\",\"long\":1}")));
    }
    @Test
    void testServerPort() throws Exception{
        Assertions.assertThat(port).isEqualTo(8082);
    }
    //@Test
    void TestException() throws Exception{
        org.junit.jupiter.api.Assertions.assertThrows(NestedServletException.class,()->{mvc.perform(get("/exception"));});
    }
}
