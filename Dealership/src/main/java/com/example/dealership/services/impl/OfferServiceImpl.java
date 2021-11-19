package com.example.dealership.services.impl;

import com.example.dealership.models.entityModels.Brand;
import com.example.dealership.models.entityModels.ModelEntity;
import com.example.dealership.models.entityModels.Offer;
import com.example.dealership.models.serviceModels.OfferServiceModel;
import com.example.dealership.repositories.BrandRepository;
import com.example.dealership.repositories.ModelRepository;
import com.example.dealership.repositories.OfferRepository;
import com.example.dealership.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {
    private final ModelMapper modelMapper;
    private final OfferRepository offerRepository;
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;

    public OfferServiceImpl(ModelMapper modelMapper, OfferRepository offerRepository, BrandRepository brandRepository, ModelRepository modelRepository) {
        this.modelMapper = modelMapper;
        this.offerRepository = offerRepository;
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public void addOffer(OfferServiceModel offerServiceModel) {
        Offer offer = modelMapper.map(offerServiceModel, Offer.class);
        Brand brand = modelMapper.map(offerServiceModel, Brand.class);
        ModelEntity model = modelMapper.map(offerServiceModel, ModelEntity.class);
        offer.setBrand(brand);
        offer.setModel(model);
        offerRepository.save(offer);
    }
}
