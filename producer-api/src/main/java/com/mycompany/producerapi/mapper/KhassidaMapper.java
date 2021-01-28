package com.mycompany.producerapi.mapper;

import com.mycompany.producerapi.model.Khassida;
import com.mycompany.producerapi.model.Khassida;
import com.mycompany.producerapi.rest.dto.CreateKhassidaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KhassidaMapper {

    Khassida toKhassida(CreateKhassidaDto createKhassidaDto);

}
