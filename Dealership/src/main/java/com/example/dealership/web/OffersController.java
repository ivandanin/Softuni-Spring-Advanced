package com.example.dealership.web;

import com.example.dealership.models.bindingModels.OfferBindingModel;
import com.example.dealership.models.serviceModels.OfferServiceModel;
import com.example.dealership.services.OfferService;
import com.example.dealership.services.BrandService;
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
public class OffersController {

    private final OfferService offerService;
    private final ModelMapper modelMapper;

    public OffersController(OfferService offerService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/offers/all")
    public String allOffers(Model model) {
        model.addAttribute("offers", offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/offers/add")
    public String addOffer(Model model) {
        if(!model.containsAttribute("offerBindingModel")){
            model.addAttribute("offerBindingModel", new OfferBindingModel());
        }
            return "add-offer";
    }

    @PostMapping("/offers/add")
    public String addOffer(@Valid OfferBindingModel offerBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerBindingModel", offerBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerBindingModel", bindingResult);
            return "redirect:/offers/add";
        }
        offerService.addOffer(modelMapper.map(offerBindingModel, OfferServiceModel.class));
        return "redirect:/";
    }
}
