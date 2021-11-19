package com.example.dealership.models.bindingModels;

import com.example.dealership.models.entityModels.enums.EngineEnum;
import com.example.dealership.models.entityModels.enums.TransmissionEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class OfferAddBindingModel {

    @Size(min = 2, max = 20, message = "The length must be between 2 and 20 characters!")
    private String brand;

    @Size(min = 2, max = 20, message = "The length must be between 2 and 20 characters!")
    private String model;

    @Min(1930)
    private Integer manufactureYear;

    @NotNull(message = "Please, choose the transmission type!")
    private TransmissionEnum transmission;

    @NotNull(message = "Please, choose the engine type!")
    private EngineEnum engine;

    @NotNull(message = "Please insert the mileage!")
    private Integer mileage;

    @NotNull(message = "Please, insert the price!")
    private BigDecimal price;
    private String imageUrl;

    @Size(min = 10, message = "The length must be more than 10 characters!")
    private String description;

    public OfferAddBindingModel() {
    }

    public String getBrand() {
        return brand;
    }

    public OfferAddBindingModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferAddBindingModel setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public OfferAddBindingModel setManufactureYear(Integer manufactureYear) {
        this.manufactureYear = manufactureYear;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferAddBindingModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferAddBindingModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferAddBindingModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferAddBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
