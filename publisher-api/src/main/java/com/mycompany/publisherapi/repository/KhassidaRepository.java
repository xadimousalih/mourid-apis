package com.mycompany.publisherapi.repository;

import com.mycompany.publisherapi.model.Khassida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface KhassidaRepository extends ElasticsearchRepository<Khassida, String> {

    Page<Khassida> findByTitreOrTeunkOrAuteurOrCategorieAllIgnoreCase(String titre, String teunk, String auteur, String category, Pageable pageable);
}
