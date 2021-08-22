package com.example.demo_it.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HelloControllerUnitTest {

	@Test
	void helloTest() {
		// Dado que
		String name = "Jhonny";
		HelloController hc = new HelloController();
		
		// Quando
		String hcReturn = hc.hello(name);
		
		// Entao
		assertEquals("Hello, " + name + " !", hcReturn);		
	}
}
