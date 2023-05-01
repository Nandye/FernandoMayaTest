package com.example.demo.application.service;

import com.example.demo.application.repository.PricesRepository;
import com.example.demo.domain.Prices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PricesService {

    private final PricesRepository pricesRepository;

    public List<Prices> getPricesOnDemandDate(LocalDateTime demandDate, Long productId, Long brandId) {
        return pricesRepository.getPricesOnDemandDate(demandDate, productId, brandId);
    }
}
