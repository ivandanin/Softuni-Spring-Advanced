package com.example.forecast.models.entityModels;

import com.example.forecast.models.entityModels.enums.WeatherEnum;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "forecasts")
public class Forecast extends BaseEntity {

    private LocalDateTime dateAndTime;
    private Integer maxTemperature; //Celsius
    private Integer minTemperature; //Celsius
    private Integer pressure; //hPa
    private Integer humidity; //%
    private Integer precipitation; //%
    private Double windSpeed; //km/h
    private WeatherEnum weather; //km/h

    @OneToOne
    private City city;

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public Forecast setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
        return this;
    }

    public Integer getMaxTemperature() {
        return maxTemperature;
    }

    public Forecast setMaxTemperature(Integer maxTemperature) {
        this.maxTemperature = maxTemperature;
        return this;
    }

    public Integer getMinTemperature() {
        return minTemperature;
    }

    public Forecast setMinTemperature(Integer minTemperature) {
        this.minTemperature = minTemperature;
        return this;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Forecast setPressure(Integer pressure) {
        this.pressure = pressure;
        return this;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Forecast setHumidity(Integer humidity) {
        this.humidity = humidity;
        return this;
    }

    public Integer getPrecipitation() {
        return precipitation;
    }

    public Forecast setPrecipitation(Integer precipitation) {
        this.precipitation = precipitation;
        return this;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public Forecast setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
        return this;
    }

    public WeatherEnum getWeather() {
        return weather;
    }

    public Forecast setWeather(WeatherEnum weather) {
        this.weather = weather;
        return this;
    }

    public City getCity() {
        return city;
    }

    public Forecast setCity(City city) {
        this.city = city;
        return this;
    }
}