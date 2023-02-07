package com.pawfor.trainingApplication.service;

import com.pawfor.trainingApplication.exceptions.TrainingNotFoundException;
import com.pawfor.trainingApplication.model.Training;
import com.pawfor.trainingApplication.repository.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepository;

    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    public void saveNewTraining(Training training) {
        trainingRepository.save(training);
    }

    public Training getTrainingById(Long id) throws Exception {
       return trainingRepository.findById(id).orElseThrow(TrainingNotFoundException::new);
    }

    public String calculateAvgSpeed(final Training training) {
        double hours = training.getDuration().getHour();
        double minutes = training.getDuration().getMinute();
        double seconds = training.getDuration().getSecond();

        double sumOfHours = hours  + (minutes/60) + (seconds/3600);

        BigDecimal speed = new BigDecimal(training.getDistance()/sumOfHours).setScale(2, RoundingMode.HALF_UP);

        return speed + " km/h";
    }

    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
    }


}
