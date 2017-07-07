package com.zyzakj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebSpringSecurityApplicationTests {

	@Test
	public void contextLoads() {
		String actual = "abc";
		assertEquals("abc",actual);
	}

}
