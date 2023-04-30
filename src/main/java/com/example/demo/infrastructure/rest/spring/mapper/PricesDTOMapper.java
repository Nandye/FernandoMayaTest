package com.example.demo.infrastructure.rest.spring.mapper;

import com.example.demo.domain.Prices;
import com.example.demo.infrastructure.rest.spring.dto.PricesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PricesDTOMapper {

    PricesDTOMapper INSTANCE = Mappers.getMapper(PricesDTOMapper.class);

    PricesDTO toPricesDTO(Prices prices);

    Prices toPrices(PricesDTO pricesDTO);


}
