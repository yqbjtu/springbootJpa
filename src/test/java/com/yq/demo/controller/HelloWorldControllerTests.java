package com.yq.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldControllerTests {
  private MockMvc mvc;

  @Before
  public void setUp() throws Exception {
      MockitoAnnotations.initMocks(this);
      //this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();

      mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
  }

  @Test
  public void getHello() throws Exception {
      mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
//              .andExpect(MockMvcResultMatchers.status().isOk())
              .andDo(MockMvcResultHandlers.print())
              .andReturn();
  }
}
