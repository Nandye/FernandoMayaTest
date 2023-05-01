package com.example.demo.application.repository;

import com.example.demo.domain.Prices;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesRepository {
    List<Prices> getPricesOnDemandDate(LocalDateTime demandDate, Long productId, Long brandId);
}
