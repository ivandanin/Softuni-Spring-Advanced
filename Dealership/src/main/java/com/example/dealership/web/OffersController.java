package com.example.dealership.web;

import com.example.dealership.models.bindingModels.OfferBindingModel;
import com.example.dealership.models.serviceModels.OfferServiceModel;
import com.example.dealership.services.OfferService;
import com.example.dealership.services.impl.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private final OfferService offerService;
    private final ModelMapper modelMapper;
    private final BrandService brandService;

    public OffersController(OfferService offerService, ModelMapper modelMapper, BrandService brandService) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
        this.brandService = brandService;
    }
    @GetMapping("/all")
    public String allOffers(Model model) {
        model.addAttribute("offers", offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/add")
    public String addOffer() {
        return "add-offer";
    }
    @PostMapping("/add")
    public String addOffer(@Valid OfferBindingModel offerBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerBindingModel", offerBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.valdiation.BindingResult.offerBindingModel", bindingResult);
            return "redirect:add";
        }
        OfferServiceModel offerServiceModel = modelMapper.map(offerBindingModel, OfferServiceModel.class);
        offerService.addOffer(offerServiceModel);

        return "redirect:/";
    }
}
