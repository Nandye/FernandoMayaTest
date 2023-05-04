package com.example.demo.infrastructure.db.repository;

import com.example.demo.application.repository.PricesRepository;
import com.example.demo.domain.Price;
import com.example.demo.infrastructure.db.mapper.PricesEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PriceRepositoryImpl implements PricesRepository {

    private final PricesCriteriaRepository pricesCriteriaRepository;

    @Override
    public List<Price> getPricesOnDemandDate(LocalDateTime demandDate, Long productId, Long brandId) {
        return pricesCriteriaRepository
                .getPricesOfDemandDate(demandDate, productId, brandId)
                .stream()
                .map(PricesEntityMapper.INSTANCE::pricesEntityToPrices)
                .collect(Collectors.toList());
    }
}
