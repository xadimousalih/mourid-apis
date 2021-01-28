package com.mycompany.collectorservice.repository;

import com.mycompany.collectorservice.model.Bayite;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BayiteRepository extends ElasticsearchRepository<Bayite, String> {

}
