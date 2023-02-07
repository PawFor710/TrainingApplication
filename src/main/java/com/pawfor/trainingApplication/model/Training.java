package com.pawfor.trainingApplication.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "trainings")
public class Training {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate date;
    @Column(name = "distance")
    private double distance;
    @Column(name = "duration")
    @JsonFormat(pattern = "hh:mm:ss")
    private LocalTime duration;
    @Column(name = "calories")
    private int calories;
    @Column(name = "description")
    private String description;

}
