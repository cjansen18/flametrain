package com.redsparksystems.flametrain;

import com.redsparksystems.flametrain.model.Responder;
import com.redsparksystems.flametrain.model.ResponderRepository;
import com.redsparksystems.flametrain.model.TrainingEvent;
import com.redsparksystems.flametrain.model.TrainingEventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Initializer implements CommandLineRunner {

    private ResponderRepository responderRepository;
    private TrainingEventRepository trainingEventRepository;

    public Initializer(ResponderRepository responderRepository,
                       TrainingEventRepository trainingEventRepository){
        this.responderRepository=responderRepository; this.trainingEventRepository=trainingEventRepository; }

    @Override
    public void run(String... args) throws Exception {
//        TrainingEvent trainingEvent=TrainingEvent.builder().className("Alarms").classStartDate(LocalDateTime.of(2018, 3, 30, 12, 30)).classEndDate(LocalDateTime.of(2018, 3, 31, 12, 30)).build();
//
//        Responder savedJansen=responderRepository.save(Responder.builder().firstName("Chris").lastName("Jansen").build());
//        responderRepository.save(Responder.builder().firstName("Matt").lastName("Westover").build());
//        responderRepository.save(Responder.builder().firstName("Larry").lastName("Karp").build());
//
//
//        trainingEventRepository.save(trainingEvent);
    }
}
