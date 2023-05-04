package com.example.demo.infrastructure.db.repository;

import com.example.demo.domain.Price;
import com.example.demo.infrastructure.db.entity.PriceEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceRepositoryImplTest {

    @InjectMocks
    private PriceRepositoryImpl priceRepositoryImp;

    @Mock
    private PricesCriteriaRepository pricesCriteriaRepository;

    @Test
    void should_retrieve_data_correctly() {
        when(pricesCriteriaRepository.getPricesOfDemandDate(any(), any(), any()))
                .thenReturn(Collections.singletonList(
                        PriceEntity.builder()
                                .price(234.43D)
                                .priceList(1)
                                .productId(2343L)
                                .brandId(1L)
                                .startDate(LocalDateTime.now())
                                .endDate(LocalDateTime.now()).id(1L)
                                .build()));
        List<Price> priceOnDemandDate = priceRepositoryImp.getPricesOnDemandDate(LocalDateTime.now(), 1L, 1L);
        assertEquals(1, priceOnDemandDate.size());
    }
}