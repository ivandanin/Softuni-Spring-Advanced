package com.example.dealership.web;

import com.example.dealership.models.bindingModels.OfferAddBindingModel;
import com.example.dealership.models.serviceModels.OfferServiceModel;
import com.example.dealership.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OffersController {
    private final OfferService offerService;
    private final ModelMapper modelMapper;

    public OffersController(OfferService offerService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    private OfferAddBindingModel offerAddBindingModel() {
        return new OfferAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {
        return "add-offer";
    }

    @PostMapping("/add")
    public String add(@Valid OfferAddBindingModel offerAddBindingModel,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerAddBindingModel", offerAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel", bindingResult);

            return "redirect:/offers/add";
        }
        offerService.addOffer(modelMapper.map(offerAddBindingModel, OfferServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/all")
    public String allOffers(Model model) {
        model.addAttribute("offersViewModel", offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/{id}/details")
    public String offerDetails(@PathVariable Long id, Model model) {
        model.addAttribute("offer", offerService.findById(id));
        return "details";
    }
}
