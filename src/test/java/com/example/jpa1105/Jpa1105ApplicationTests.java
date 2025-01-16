package com.example.jpa1105;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.sun.media.sound.ModelInstrument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Jpa1105ApplicationTests {

	@Autowired
	private DramaRepository dramaRepository;

	@Test
	public void testDirectorJoin() {
		Drama drama = dramaRepository.findById(1L).orElseThrow();
		assertNotNull(drama.getDirector());  // Director가 null이 아니어야 함
		System.out.println(drama.getDirector());  // Director 정보 출력
	}

}




