package com.moulik.journalApp;

import com.moulik.journalApp.repository.Userrepo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class JournalAppApplicationTests {
    @Autowired
	Userrepo ur;
	@Test
	public void add(){
		assertEquals(2,1+1);
	}
	@ParameterizedTest
	@ValueSource(strings={"Moulik",
	"Hatu","FAKER","Shang Pang"})

	public void checkuserNAme (String name) {
		assertNotNull(ur.findByUsername(name));
	}
	@ParameterizedTest
	@CsvSource({"1,1,2",
			"2,2,4","4,4,12"})

	public void test(int a, int b, int c) {
		assertEquals(c, a + b);
	}

}
