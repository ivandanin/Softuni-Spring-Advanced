package com.example.mobilele.services;

import com.example.mobilele.models.viewModels.StatsView;

public interface StatsService {
    void onRequest();
    StatsView getStats();
}
