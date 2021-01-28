package com.mycompany.collectorservice.repository;

import com.mycompany.collectorservice.model.Khassida;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface KhassidaRepository extends ElasticsearchRepository<Khassida, String> {

}
