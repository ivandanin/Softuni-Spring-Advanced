package com.example.dealership.services.impl;

import com.example.dealership.models.entityModels.Offer;
import com.example.dealership.models.serviceModels.OfferServiceModel;
import com.example.dealership.models.viewModels.OfferSummaryView;
import com.example.dealership.repositories.OfferRepository;
import com.example.dealership.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferSummaryView> getAllOffers() {
        return offerRepository
                .findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
    private OfferSummaryView map(Offer offer) {
        OfferSummaryView offerSummaryView = this.modelMapper.map(offer, OfferSummaryView.class);

        offerSummaryView.setModel(offer.getModel().getName());
        offerSummaryView.setBrand(offer.getModel().getBrand().getName());

        return offerSummaryView;
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }

    @Override
    public void addOffer(OfferServiceModel offerServiceModel) {
        Offer newOffer = modelMapper.map(offerServiceModel, Offer.class);
        offerRepository.save(newOffer);

    }
}
