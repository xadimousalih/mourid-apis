package com.mycompany.producerapi.mapper;

import com.mycompany.producerapi.model.Bayite;
import com.mycompany.producerapi.rest.dto.CreateBayiteDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BayiteMapper {

    Bayite toBayite(CreateBayiteDto createBayiteDto);

}
