package DTO;

public class TimeFrameDTO {
    private String day;
    private double beginTime;
    private double endTime;

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    public double getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(double beginTime) {
        this.beginTime = beginTime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
