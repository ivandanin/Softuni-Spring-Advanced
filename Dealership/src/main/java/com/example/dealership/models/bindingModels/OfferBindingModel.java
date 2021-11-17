package com.example.dealership.models.bindingModels;

import com.example.dealership.models.entityModels.enums.EngineEnum;
import com.example.dealership.models.entityModels.enums.TransmissionEnum;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class OfferBindingModel {

    private Long id;
    private String brand;
    @NotNull
    private String model;
    @NotNull
    @DecimalMin("100")
    private BigDecimal price;
    @NotNull
    private EngineEnum engine;
    @NotNull
    private TransmissionEnum transmission;
    @NotNull
    @Min(1930)
    private Integer year;
    @NotNull
    @PositiveOrZero
    private Integer mileage;
    @NotEmpty
    private String description;
    @NotEmpty
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public OfferBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public OfferBindingModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferBindingModel setModel(String model) {
        this.model = model;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferBindingModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferBindingModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferBindingModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferBindingModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
