package com.mycompany.collectorservice.mapper;

import com.mycompany.collectorservice.model.Khassida;
import com.mycompany.commonskhassida.avro.KhassidaEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = StringMapper.class)
public interface KhassidaMapper {

    Khassida toKhassida(KhassidaEvent khassidaEvent);

}
