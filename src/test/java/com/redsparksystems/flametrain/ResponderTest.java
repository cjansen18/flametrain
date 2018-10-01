package com.redsparksystems.flametrain;

import com.redsparksystems.flametrain.model.Responder;
import com.redsparksystems.flametrain.model.ResponderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResponderTest {

	@Autowired
	private ResponderRepository responderRepository;
	@Test
	public void findAllResponders() {
		Iterable<Responder> responders=responderRepository.findAll();
		assertThat(responders).isNotNull();
	}

}
