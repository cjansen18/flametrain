package com.redsparksystems.flametrain;

import com.redsparksystems.flametrain.model.Responder;
import com.redsparksystems.flametrain.model.ResponderRepository;
import com.redsparksystems.flametrain.model.TrainingEvent;
import com.redsparksystems.flametrain.model.TrainingEventRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainingEventTest {

	@Autowired
	private TrainingEventRepository trainingEventRepository;

	@Autowired
	private ResponderRepository responderRepository;

	@Test
	public void findAllTrainingEvents() {

		TrainingEvent trainingEvent=TrainingEvent.builder().className("Alarms").classStartDate(LocalDateTime.of(2018, 3, 30, 12, 30)).classEndDate(LocalDateTime.of(2018, 3, 31, 12, 30)).build();

		Responder jansenResponder=(Responder.builder().firstName("Chris").lastName("Jansen").build());
		Responder westoverResponder=(Responder.builder().firstName("Matt").lastName("Westover").build());

		trainingEvent.getResponderSet().add(jansenResponder);
		trainingEvent.getResponderSet().add(westoverResponder);

		jansenResponder.getTrainingEvents().add(trainingEvent);
		westoverResponder.getTrainingEvents().add(trainingEvent);

		trainingEventRepository.save(trainingEvent);

		Iterable<TrainingEvent> trainingEvents=trainingEventRepository.findAll();
		assertThat(trainingEvents).isNotNull();

		Iterable responders=responderRepository.findAll();
		assertThat(responders).isNotNull();
	}

}
