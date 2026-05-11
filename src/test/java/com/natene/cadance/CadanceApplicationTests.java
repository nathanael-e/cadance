package com.natene.cadance;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TestDatabaseConfig.class)
class CadanceApplicationTests {

	@Test
	void contextLoads() {
	}

}
