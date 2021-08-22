package com.example.demo_it.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = HelloController.class)
class HelloControllerIntegrationTest {

	@Autowired private MockMvc mockMvc;
	
	@Test void helloTest() {
		RequestBuilder rb = MockMvcRequestBuilders.get("/api/hello/");
		
		try {
			MvcResult result = mockMvc.perform(rb).andReturn();
			assertEquals("Hello, World !", result.getResponse().getContentAsString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test void helloTestWithName() {
		String name = "Daniel";
		RequestBuilder rb = MockMvcRequestBuilders.get("/api/hello/").param("name", name);
		
		try {
			mockMvc.perform(rb).andExpect(content().string("Hello, " + name + " !"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

}
