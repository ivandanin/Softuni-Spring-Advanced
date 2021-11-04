package com.example.mobilele.init;

import com.example.mobilele.services.BrandService;
import com.example.mobilele.services.ModelService;
import com.example.mobilele.services.OfferService;
import com.example.mobilele.services.UserEntityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandService brandService;
    private final ModelService modelService;
    private final UserEntityService userService;
    private final OfferService offerService;

    public DBInit(BrandService brandService, ModelService modelService, UserEntityService userService, OfferService offerService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.userService = userService;
        this.offerService = offerService;
    }

    @Override
    public void run(String... args) throws Exception {
        brandService.initializeBrand();
        modelService.initializeModels();
        userService.initializeUsersAndRoles();
        offerService.initializeOffers();
    }
}
