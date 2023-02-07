package com.pawfor.trainingApplication.mapper;

import com.pawfor.trainingApplication.model.Training;
import com.pawfor.trainingApplication.model.dto.TrainingDto;
import com.pawfor.trainingApplication.model.dto.TrainingWithAvgSpeedDto;
import com.pawfor.trainingApplication.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainingMapper {

    private final TrainingService trainingService;


    public Training mapToTraining(final TrainingDto trainingDto) {
        return new Training(
                trainingDto.getId(),
                trainingDto.getDate(),
                Double.parseDouble(trainingDto.getDistance()),
                trainingDto.getDuration(),
                Integer.parseInt(trainingDto.getCalories()),
                trainingDto.getDescription()
        );
    }

    public TrainingDto mapToTrainingDto(final Training training) {
        return new TrainingDto(
                training.getId(),
                training.getDate(),
                training.getDistance() + " km",
                training.getDuration(),
                training.getCalories() + " kCal",
                training.getDescription()
        );
    }

    public List<TrainingDto> mapToTrainingDtoList(final List<Training> trainings) {
        return trainings.stream()
                .map(this::mapToTrainingDto)
                .collect(Collectors.toList());
    }

    public TrainingWithAvgSpeedDto mapToTrainingWithAvgSpeedDto(final Training training) {
        return new TrainingWithAvgSpeedDto(
                training.getId(),
                training.getDate(),
                training.getDistance() + " km",
                training.getDuration(),
                training.getCalories() + " kCal",
                training.getDescription(),
                trainingService.calculateAvgSpeed(training)
        );
    }
}
