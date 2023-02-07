package com.pawfor.trainingApplication.controller;

import com.pawfor.trainingApplication.mapper.TrainingMapper;
import com.pawfor.trainingApplication.model.Training;
import com.pawfor.trainingApplication.model.dto.TrainingDto;
import com.pawfor.trainingApplication.model.dto.TrainingWithAvgSpeedDto;
import com.pawfor.trainingApplication.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/trainings")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;
    private final TrainingMapper trainingMapper;

    @GetMapping
    public ResponseEntity<List<TrainingDto>> getAllTrainings() {
        return ResponseEntity.ok(trainingMapper.mapToTrainingDtoList(trainingService.getAllTrainings()));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createNewTraining(@RequestBody TrainingDto trainingDto ) {
        Training training = trainingMapper.mapToTraining(trainingDto);
        trainingService.saveNewTraining(training);
        return ResponseEntity.created(URI.create("v1/trainings")).build();
    }

    @PutMapping
    public ResponseEntity<TrainingDto> updateTraining(@RequestBody TrainingDto trainingDto) {
        Training training = trainingMapper.mapToTraining(trainingDto);
        trainingService.saveNewTraining(training);
        return ResponseEntity.ok(trainingDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingWithAvgSpeedDto> getTrainingById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(trainingMapper.mapToTrainingWithAvgSpeedDto(trainingService.getTrainingById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraining(@PathVariable Long id) {
        trainingService.deleteTraining(id);
        return ResponseEntity.ok().build();
    }
}
