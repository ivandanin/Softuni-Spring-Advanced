package com.example.forecast.web;

import com.example.forecast.services.StatsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StatsController {

    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/statistics")
    public ModelAndView statistics() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("statistics", statsService.getStats());
        modelAndView.setViewName("statistics");
        return modelAndView;
    }
}
