package com.example.demo.infrastructure.rest.spring.controller;

import com.example.demo.application.service.PricesService;
import com.example.demo.domain.Price;
import com.example.demo.infrastructure.rest.spring.dto.PriceDTO;
import com.example.demo.infrastructure.rest.spring.dto.PricesFilterDTO;
import com.example.demo.infrastructure.rest.spring.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

    @InjectMocks
    private PricesController pricesController;

    @Mock
    private PricesService pricesService;

    @Test
    void should_retrieve_data_correctly() throws NotFoundException {
        when(pricesService.getPricesOnDemandDate(any(), any(), any()))
                .thenReturn(Price.builder().price(23.43D).priceList(1).productId(2L)
                        .startDate(LocalDateTime.now()).endDate(LocalDateTime.now())
                        .brandId(1L).curr("EUR").build()
                );

        ResponseEntity<PriceDTO> price = pricesController
                .getPricesOnDemandDate(PricesFilterDTO.builder()
                        .demandDate(LocalDateTime.now())
                        .productId(1L)
                        .brandId(1L)
                        .build());
        assertNotNull(price);
    }

}