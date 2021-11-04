package com.example.mobilele.models.viewModels;

import com.example.mobilele.models.entityModels.enums.EngineEnum;
import com.example.mobilele.models.entityModels.enums.TransmissionEnum;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OfferDetailsView {

    private Long id;
    private LocalDateTime created;
    private LocalDateTime modified;
    private EngineEnum engine;
    private String description;
    @Column(columnDefinition = "TEXT")
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    private TransmissionEnum transmission;
    private Integer year;
    private String model;
    private String brand;
    private String sellerFullName;

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferDetailsView setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OfferDetailsView setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public OfferDetailsView setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public OfferDetailsView setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferDetailsView setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferDetailsView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferDetailsView setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferDetailsView setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferDetailsView setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferDetailsView setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferDetailsView setModel(String model) {
        this.model = model;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public OfferDetailsView setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public OfferDetailsView setSellerFullName(String fullName) {
        this.sellerFullName = fullName;
        return this;
    }

    public String getSellerFullName() {
        return sellerFullName;
    }

}
