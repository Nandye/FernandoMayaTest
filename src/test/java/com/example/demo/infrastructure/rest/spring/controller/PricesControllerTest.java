package com.example.demo.infrastructure.rest.spring.controller;

import com.example.demo.application.service.PricesService;
import com.example.demo.domain.Prices;
import com.example.demo.infrastructure.rest.spring.dto.PricesDTO;
import com.example.demo.infrastructure.rest.spring.dto.PricesFilterDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PricesControllerTest {

    @InjectMocks
    private PricesController pricesController;

    @Mock
    private PricesService pricesService;

    @Test
    void should_retrieve_data_correctly() {
        when(pricesService.getPricesOnDemandDate(any(), any(), any()))
                .thenReturn(Collections.singletonList(
                        Prices.builder().price(23.43D).priceList(1).productId(2L)
                                .startDate(LocalDateTime.now()).endDate(LocalDateTime.now())
                                .brandId(1L).curr("EUR").build()));

        ResponseEntity<List<PricesDTO>> pricesOnDemandDate = pricesController
                .getPricesgetPricesOnDemandDate(PricesFilterDTO.builder()
                        .demandDate(LocalDateTime.now())
                        .productId(1L)
                        .brandId(1L)
                        .build());
        assertEquals(1, Objects.requireNonNull(pricesOnDemandDate.getBody()).size());
    }

}