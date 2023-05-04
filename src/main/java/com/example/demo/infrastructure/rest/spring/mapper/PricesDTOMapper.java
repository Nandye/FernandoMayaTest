package com.example.demo.infrastructure.rest.spring.mapper;

import com.example.demo.domain.Price;
import com.example.demo.infrastructure.rest.spring.dto.PriceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PricesDTOMapper {

    PricesDTOMapper INSTANCE = Mappers.getMapper(PricesDTOMapper.class);

    PriceDTO toPricesDTO(Price price);

    Price toPrices(PriceDTO priceDTO);


}
