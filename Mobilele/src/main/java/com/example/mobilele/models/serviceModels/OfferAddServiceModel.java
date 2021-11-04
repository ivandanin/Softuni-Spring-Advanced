package com.example.mobilele.models.serviceModels;

import com.example.mobilele.models.entityModels.enums.EngineEnum;
import com.example.mobilele.models.entityModels.enums.TransmissionEnum;

import java.math.BigDecimal;

public class OfferAddServiceModel {
    private Long id;
    private Long modelId;
    private String description;
    private EngineEnum engine;
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    private TransmissionEnum transmission;
    private Integer year;

    public Long getId() {
        return id;
    }

    public OfferAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getModelId() {
        return modelId;
    }

    public OfferAddServiceModel setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferAddServiceModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferAddServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferAddServiceModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferAddServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferAddServiceModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferAddServiceModel setYear(Integer year) {
        this.year = year;
        return this;
    }
}
