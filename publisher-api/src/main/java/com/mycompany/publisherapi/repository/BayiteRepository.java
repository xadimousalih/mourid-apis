package com.mycompany.publisherapi.repository;

import com.mycompany.publisherapi.model.Bayite;
import com.mycompany.publisherapi.model.Khassida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BayiteRepository extends ElasticsearchRepository<Bayite, String> {

    Page<Bayite> getBayitesByKhassida(String khassida, Pageable pageable);
    Page<Bayite> findByNumeroOrBayitearOrBayitefrOrBayiteenOrBayiteitOrBayiteitOrBayiteesOrBayitewoOrBayiteptOrBayitechOrKhassidaAllIgnoreCase(String numero, String bayitear,
                                                                                                                                               String bayitefr,
                                                                                                                                               String bayiteen,
                                                                                                                                               String bayiteit,
                                                                                                                                               String bayitees,
                                                                                                                                               String bayitewo,
                                                                                                                                               String bayitept,
                                                                                                                                               String bayitech,
                                                                                                                                               String khassida, Pageable pageable);


}
