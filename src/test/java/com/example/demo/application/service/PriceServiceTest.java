package com.example.demo.application.service;

import com.example.demo.application.repository.PricesRepository;
import com.example.demo.domain.Price;
import com.example.demo.infrastructure.rest.spring.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

    @InjectMocks
    private PricesService pricesService;
    @Mock
    private PricesRepository pricesRepository;

    @Test
    void should_retrieve_prices_correctly() throws NotFoundException {
        when(pricesRepository.getPricesOnDemandDate(any(), any(), any()))
                .thenReturn(Collections.singletonList(
                        Price.builder()
                                .price(234.43D)
                                .priceList(1)
                                .productId(2343L)
                                .brandId(1L)
                                .startDate(LocalDateTime.now())
                                .endDate(LocalDateTime.now()).id(1L)
                                .build()));
        Price price = pricesService.getPricesOnDemandDate(LocalDateTime.now(), 1L, 1L);
        assertNotNull(price);
    }
}