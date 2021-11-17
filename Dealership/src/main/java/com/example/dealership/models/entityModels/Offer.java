package com.example.dealership.models.entityModels;

import com.example.dealership.models.entityModels.enums.EngineEnum;
import com.example.dealership.models.entityModels.enums.TransmissionEnum;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @Column(columnDefinition = "LONGTEXT")
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private EngineEnum engine;

    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;
    private Integer manufactureYear;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private ModelEntity model;

    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Offer setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Offer setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Offer setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public Offer setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public Offer setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public Offer setManufactureYear(Integer manufactureYear) {
        this.manufactureYear = manufactureYear;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public Offer setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public Offer setModel(ModelEntity model) {
        this.model = model;
        return this;
    }
}
