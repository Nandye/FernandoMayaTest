package com.example.demo.infrastructure.db.mapper;

import com.example.demo.domain.Prices;
import com.example.demo.infrastructure.db.entity.PricesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PricesEntityMapper {

    PricesEntityMapper INSTANCE = Mappers.getMapper(PricesEntityMapper.class);

    Prices pricesEntityToPrices(PricesEntity pricesEntity);

}
