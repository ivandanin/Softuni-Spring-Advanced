package com.example.dealership.models.entityModels;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<ModelEntity> models;

    public List<ModelEntity> getModels() {
        return models;
    }

    public Brand setModels(List<ModelEntity> models) {
        this.models = models;
        return this;
    }
}
