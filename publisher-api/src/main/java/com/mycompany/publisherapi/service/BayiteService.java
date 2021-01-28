package com.mycompany.publisherapi.service;

import com.mycompany.publisherapi.model.Bayite;
import com.mycompany.publisherapi.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BayiteService {

    Bayite validateAndGetBayiteById(String id);

    public Page<Bayite> getBayitesByKhassida(String khassida, Pageable pageable);
    Page<Bayite> listAllBayiteByPage(Pageable pageable);

    /*Page<Bayite> search(int numero, String bayitear,
                        String bayitefr,
                        String bayiteen,
                        String bayiteit,
                        String bayitees,
                        String bayitewo,
                        String bayitept,
                        String bayitech,
                        String khassida, Pageable pageable);
*/
}
