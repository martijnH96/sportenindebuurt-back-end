package DTO;

import static java.lang.Math.round;

public class SportsDTO {
    String sport;
    double sportLevel;

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getSport() {
        return sport;
    }

    public double getSportLevel() {
        return round(sportLevel);
    }

    public void setSportLevel(double sportLevel) {
        this.sportLevel = sportLevel;
    }
}
