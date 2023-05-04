package com.example.demo.application.service;

import com.example.demo.application.repository.PricesRepository;
import com.example.demo.domain.Price;
import com.example.demo.infrastructure.rest.spring.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;

@Service
@RequiredArgsConstructor
public class PricesService {

    private final PricesRepository pricesRepository;

    public Price getPricesOnDemandDate(LocalDateTime demandDate, Long productId, Long brandId) throws NotFoundException {
        return pricesRepository.getPricesOnDemandDate(demandDate, productId, brandId)
                .stream().max(Comparator.comparingDouble(Price::getPriority)).orElseThrow(NotFoundException::new);

    }
}
