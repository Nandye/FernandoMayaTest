package com.example.demo.infrastructure.db.repository;

import com.example.demo.domain.Prices;
import com.example.demo.infrastructure.db.entity.PricesEntity;
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

@ExtendWith({MockitoExtension.class})
class PriceRepositoryImplTest {

    @InjectMocks
    private PriceRepositoryImpl priceRepository;

    @Mock
    private PricesCriteriaRepository pricesCriteriaRepository;

    @Test
    void should_return_price_list_correctly() {

        when(pricesCriteriaRepository.getPricesOfDemandDate(any(), any(), any()))
                .thenReturn(Collections.singletonList(PricesEntity.builder().price(135.4D).priceList(1).curr("EUR")
                        .productId(123L).brandId(1L).build()));
        List<Prices> pricesOnDemandDate =
                priceRepository.getPricesOnDemandDate(LocalDateTime.now(), 1L, 1L);
        assertEquals(1, pricesOnDemandDate.size());

    }

}