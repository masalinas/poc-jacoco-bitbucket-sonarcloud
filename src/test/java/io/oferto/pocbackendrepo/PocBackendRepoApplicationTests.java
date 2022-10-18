package io.oferto.pocbackendrepo;

import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

@SpringBootTest
class PocBackendRepoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void aSimple_error() {
	    String name = "ok"; 
	 
	     assertThat("ok")
	      .isEqualTo(name);
	}
}
