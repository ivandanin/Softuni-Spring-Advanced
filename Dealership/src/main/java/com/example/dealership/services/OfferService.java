package com.example.dealership.services;

import com.example.dealership.models.bindingModels.OfferBindingModel;
import com.example.dealership.models.serviceModels.OfferServiceModel;
import com.example.dealership.models.viewModels.OfferSummaryView;

import java.util.List;

public interface OfferService {
    List<OfferSummaryView> getAllOffers();
    void deleteOffer(Long id);

    void addOffer(OfferServiceModel offerServiceModel);
}
