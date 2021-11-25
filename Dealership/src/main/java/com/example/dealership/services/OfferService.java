package com.example.dealership.services;

import com.example.dealership.models.entityModels.Offer;
import com.example.dealership.models.serviceModels.OfferServiceModel;
import com.example.dealership.models.viewModels.OfferViewModel;

import java.util.List;

public interface OfferService {
    void addOffer(OfferServiceModel offerServiceModel);

    List<OfferViewModel> getAllOffers();

    OfferViewModel findById(Long id);
}
