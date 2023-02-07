package com.pawfor.trainingApplication.service;

import com.pawfor.trainingApplication.model.Training;
import com.pawfor.trainingApplication.repository.TrainingRepository;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TrainingServiceTestSuite {

    @Autowired
    private TrainingService trainingService;
    @Autowired
    private TrainingRepository trainingRepository;

    @Test
    void getAllItems() {

        //Given
        Training training1 = new Training();
        Training training2 = new Training();
        Training training3 = new Training();

        trainingService.saveNewTraining(training1);
        trainingService.saveNewTraining(training2);
        trainingService.saveNewTraining(training3);

        //When
        List<Training> result = trainingService.getAllTrainings();

        //Then
        assertEquals(result.size(), 3);

        //Cleaning
        trainingRepository.deleteAll();
    }

    @Test
    void saveTrainingTest() throws Exception {
        //Given
        Training training1 = new Training();
        trainingService.saveNewTraining(training1);

        //When
        Training result = trainingService.getTrainingById(training1.getId());

        //Then
        assertEquals(result.getCalories(), training1.getCalories());

        //Cleaning
        trainingRepository.deleteAll();
    }

    @Test
    void avgSpeedTest() {
        //Given
        Training training1 = new Training(1L, LocalDate.now(), 11.5,
                LocalTime.of(1, 5,0),300, "long run" );

        //When
        String result = trainingService.calculateAvgSpeed(training1);

        //Then
        assertEquals(result, "10.62 km/h");

    }

}