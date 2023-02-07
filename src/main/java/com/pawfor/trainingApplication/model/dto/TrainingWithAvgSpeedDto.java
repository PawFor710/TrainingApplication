package com.pawfor.trainingApplication.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingWithAvgSpeedDto {

    private Long id;
    private LocalDate date;
    private String distance;
    private LocalTime duration;
    private String calories;
    private String description;
    private String avgSpeed;

}
