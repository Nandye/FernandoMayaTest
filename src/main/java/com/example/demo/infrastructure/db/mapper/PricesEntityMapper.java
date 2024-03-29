package com.example.demo.infrastructure.db.mapper;

import com.example.demo.domain.Price;
import com.example.demo.infrastructure.db.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PricesEntityMapper {

    PricesEntityMapper INSTANCE = Mappers.getMapper(PricesEntityMapper.class);

    Price pricesEntityToPrices(PriceEntity priceEntity);

}
