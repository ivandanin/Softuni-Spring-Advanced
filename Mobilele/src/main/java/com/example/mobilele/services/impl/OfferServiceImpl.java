package com.example.mobilele.services.impl;

import com.example.mobilele.models.entityModels.Offer;
import com.example.mobilele.models.entityModels.enums.EngineEnum;
import com.example.mobilele.models.entityModels.enums.TransmissionEnum;
import com.example.mobilele.models.serviceModels.OfferUpdateServiceModel;
import com.example.mobilele.models.viewModels.OfferDetailsView;
import com.example.mobilele.models.viewModels.OfferSummaryView;
import com.example.mobilele.repos.ModelRepo;
import com.example.mobilele.repos.OfferRepo;
import com.example.mobilele.repos.UserEntityRepo;
import org.springframework.stereotype.Service;
import com.example.mobilele.services.OfferService;
import org.modelmapper.ModelMapper;
import com.example.mobilele.web.exception.ObjectNotFoundException;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepo offerRepo;
    private final ModelMapper modelMapper;
    private final ModelRepo modelRepo;
    private final UserEntityRepo userRepo;

    public OfferServiceImpl(OfferRepo offerRepo, ModelMapper modelMapper, ModelRepo modelRepo, UserEntityRepo userRepo) {
        this.offerRepo = offerRepo;
        this.modelMapper = modelMapper;
        this.modelRepo = modelRepo;
        this.userRepo = userRepo;
    }

    @Override
    public void initializeOffers() {

        if (offerRepo.count() == 0) {
        Offer offer1 = new Offer();
        offer1
                .setModel(modelRepo.findById(1L).orElse(null))
                .setEngine(EngineEnum.GASOLINE)
                .setTransmission(TransmissionEnum.AUTOMATIC)
                .setMileage(15000)
                .setPrice(new BigDecimal(25000))
                .setYear(2016)
                .setDescription("KA4wa6 se i kara6!!!")
                .setSeller(userRepo.findByUsername("pesho").orElse(null))
                .setImageUrl("https://www.autoevolution.com/news/2020-ford-fiesta-rs-probably-confirmed-by-broad-grin-125727.html#agal_0");

        Offer offer2 = new Offer();
        offer2
                .setModel(modelRepo.findById(1L).orElse(null))
                .setEngine(EngineEnum.GASOLINE)
                .setTransmission(TransmissionEnum.MANUAL)
                .setMileage(1500000)
                .setPrice(new BigDecimal(65000))
                .setYear(1993)
                .setDescription("UNIKAT!!!")
                .setSeller(userRepo.findByUsername("admin").orElse(null))
                .setImageUrl("https://en.wikipedia.org/wiki/Ford_Escort_RS_Cosworth#/media/File:1996_Ford_Escort_RS_Cosworth_2.0_Front.jpg");

        offerRepo.saveAll(List.of(offer1, offer2));
;        }
    }

    @Override
    public List<OfferSummaryView> getAllOffers() {
        return offerRepo.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepo.deleteById(id);
    }

    @Override
    public void updateOffer(OfferUpdateServiceModel offerModel) {

        Offer offer = offerRepo.findById(offerModel.getId()).orElseThrow(() ->
                new ObjectNotFoundException("Offer with id " + offerModel.getId() + " not found!"));

        offer.setPrice(offerModel.getPrice())
                .setDescription(offerModel.getDescription())
                .setEngine(offerModel.getEngine())
                .setImageUrl(offerModel.getImageUrl())
                .setMileage(offerModel.getMileage())
                .setTransmission(offerModel.getTransmission())
                .setYear(offerModel.getYear());

        offerRepo.save(offer);
    }

    @Override
    public OfferDetailsView findById(Long id) {
        return this.offerRepo.findById(id).map(this::mapDetailsView).get();
    }

    private OfferSummaryView map(Offer offer) {
        OfferSummaryView offerSummaryView = this.modelMapper.map(offer, OfferSummaryView.class);

        offerSummaryView.setModel(offer.getModel().getName());
        offerSummaryView.setBrand(offer.getModel().getBrand().getName());

        return offerSummaryView;
    }

    private OfferDetailsView mapDetailsView(Offer offer) {
        OfferDetailsView offerDetailsView = this.modelMapper.map(offer, OfferDetailsView.class);

        offerDetailsView.setModel(offer.getModel().getName());
        offerDetailsView.setBrand(offer.getModel().getBrand().getName());
        offerDetailsView.setSellerFullName(offer.getSeller().getFirstName() + " " + offer.getSeller().getLastName());

        return offerDetailsView;
    }
}
