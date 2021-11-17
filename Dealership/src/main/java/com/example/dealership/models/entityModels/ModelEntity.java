package com.example.dealership.models.entityModels;

import com.example.dealership.models.entityModels.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @Column(columnDefinition = "LONGTEXT")
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;

    @ManyToOne
    private Brand brand;

    public CategoryEnum getCategory() {
        return category;
    }

    public ModelEntity setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelEntity setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelEntity setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public ModelEntity setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }
}
