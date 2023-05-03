package com.example.demo.application.service;

import com.example.demo.application.repository.PricesRepository;
import com.example.demo.domain.Prices;
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
class PricesServiceTest {

    @InjectMocks
    private PricesService pricesService;
    @Mock
    private PricesRepository pricesRepository;

    @Test
    void should_retrieve_prices_correctly() {
        when(pricesRepository.getPricesOnDemandDate(any(), any(), any()))
                .thenReturn(Collections.singletonList(
                        Prices.builder()
                                .price(234.43D)
                                .priceList(1)
                                .productId(2343L)
                                .brandId(1L)
                                .startDate(LocalDateTime.now())
                                .endDate(LocalDateTime.now()).id(1L)
                                .build()));
        List<Prices> pricesOnDemandDate = pricesService.getPricesOnDemandDate(LocalDateTime.now(), 1L, 1L);
        assertEquals(1, pricesOnDemandDate.size());
    }
}