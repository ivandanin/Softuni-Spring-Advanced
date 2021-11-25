package com.example.dealership.services.impl;

import com.example.dealership.models.entityModels.Brand;
import com.example.dealership.models.entityModels.ModelEntity;
import com.example.dealership.models.entityModels.Offer;
import com.example.dealership.models.serviceModels.OfferServiceModel;
import com.example.dealership.models.viewModels.OfferViewModel;
import com.example.dealership.repositories.BrandRepository;
import com.example.dealership.repositories.ModelRepository;
import com.example.dealership.repositories.OfferRepository;
import com.example.dealership.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<OfferViewModel> getAllOffers() {
        return offerRepository.findAll()
                .stream().map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public OfferViewModel findById(Long id) {
        return offerRepository.findById(id)
                .map(this::mapDetails).get();
    }

    private OfferViewModel mapDetails(Offer offer) {
        OfferViewModel offerViewModel = this.modelMapper.map(offer, OfferViewModel.class);

        offerViewModel.setBrand(offer.getBrand().getName());
        offerViewModel.setModel(offer.getModel().getName());
        return offerViewModel;
    }

    private OfferViewModel map(Offer offer) {
        OfferViewModel offerViewModel = this.modelMapper.map(offer, OfferViewModel.class);

        offerViewModel.setModel(offer.getModel().getName());
        offerViewModel.setBrand(offer.getBrand().getName());

        return offerViewModel;
    }
}
