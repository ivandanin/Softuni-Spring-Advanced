package com.example.forecast.services;

import com.example.forecast.models.viewModels.StatsView;

public interface StatsService {

    void onRequest();
    StatsView getStats();
}
