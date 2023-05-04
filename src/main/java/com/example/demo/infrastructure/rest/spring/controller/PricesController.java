package com.example.demo.infrastructure.rest.spring.controller;

import com.example.demo.application.service.PricesService;
import com.example.demo.infrastructure.rest.spring.dto.PriceDTO;
import com.example.demo.infrastructure.rest.spring.dto.PricesFilterDTO;
import com.example.demo.infrastructure.rest.spring.exception.NotFoundException;
import com.example.demo.infrastructure.rest.spring.mapper.PricesDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fernando")
@RequiredArgsConstructor
public class PricesController {

    private final PricesService pricesService;

    @GetMapping(value = "/pricesOnDemandDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceDTO> getPricesOnDemandDate(PricesFilterDTO pricesFilterDTO) throws NotFoundException {

        return new ResponseEntity<>(PricesDTOMapper.INSTANCE.toPricesDTO(pricesService
                .getPricesOnDemandDate(
                        pricesFilterDTO.getDemandDate(), pricesFilterDTO.getProductId(), pricesFilterDTO.getBrandId())
        ), HttpStatus.OK);
    }
}
