package com.mycompany.collectorservice.mapper;

import com.mycompany.collectorservice.model.Bayite;
import com.mycompany.commonsbayite.avro.BayiteEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = StringMapper.class)
public interface BayiteMapper {

    Bayite toBayite(BayiteEvent bayiteEvent);

}
