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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class PricesServiceTest {

    @InjectMocks
    private PricesService pricesService;

    @Mock
    private PricesRepository pricesRepository;

    @Test
    void should_return_price_list_correctly() {
        List<Prices> pricesList = Collections.singletonList(Prices.builder().price(35.4D).priceList(1).curr("EUR").productId(123L).brandId(1L).build());
        when(pricesRepository.getPricesOnDemandDate(any(), any(), any())).thenReturn(pricesList);
        List<Prices> pricesOnDemandDate = pricesService.getPricesOnDemandDate(LocalDateTime.now(), 1L, 1L);
        assertEquals(1, pricesOnDemandDate.size());
    }


}