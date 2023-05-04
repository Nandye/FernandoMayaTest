package com.example.demo.application.repository;

import com.example.demo.domain.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesRepository {
    List<Price> getPricesOnDemandDate(LocalDateTime demandDate, Long productId, Long brandId);
}
