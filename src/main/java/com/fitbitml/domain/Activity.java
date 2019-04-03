package com.fitbitml.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@ToString
@Table(name = "trackeractivity", schema = "public")
public class Activity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "datetime")
    private Date dateTime;

    @Column(name = "calories")
    private int calories;

    @Column(name = "steps")
    private int steps;

    @Column(name = "distance")
    private double distance;

    @Column(name = "minutessedentary")
    private int minutesSedentary;

    @Column(name = "minuteslightlyactive")
    private int minutesLightlyActive;

    @Column(name = "minutesfairlyactive")
    private int minutesFairlyActive;

    @Column(name = "minutesveryactive")
    private int minutesVeryActive;

    @Column(name = "activitycalories")
    private int activityCalories;

    public Activity(Date dateTime, int calories, int steps, double distance, int minutesSedentary, int minutesLightlyActive, int minutesFairlyActive, int minutesVeryActive, int activityCalories) {
        this.dateTime = dateTime;
        this.calories = calories;
        this.steps = steps;
        this.distance = distance;
        this.minutesSedentary = minutesSedentary;
        this.minutesLightlyActive = minutesLightlyActive;
        this.minutesFairlyActive = minutesFairlyActive;
        this.minutesVeryActive = minutesVeryActive;
        this.activityCalories = activityCalories;
    }

    public Activity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getMinutesSedentary() {
        return minutesSedentary;
    }

    public void setMinutesSedentary(int minutesSedentary) {
        this.minutesSedentary = minutesSedentary;
    }

    public int getMinutesLightlyActive() {
        return minutesLightlyActive;
    }

    public void setMinutesLightlyActive(int minutesLightlyActive) {
        this.minutesLightlyActive = minutesLightlyActive;
    }

    public int getMinutesFairlyActive() {
        return minutesFairlyActive;
    }

    public void setMinutesFairlyActive(int minutesFairlyActive) {
        this.minutesFairlyActive = minutesFairlyActive;
    }

    public int getMinutesVeryActive() {
        return minutesVeryActive;
    }

    public void setMinutesVeryActive(int minutesVeryActive) {
        this.minutesVeryActive = minutesVeryActive;
    }

    public int getActivityCalories() {
        return activityCalories;
    }

    public void setActivityCalories(int activityCalories) {
        this.activityCalories = activityCalories;
    }
}
