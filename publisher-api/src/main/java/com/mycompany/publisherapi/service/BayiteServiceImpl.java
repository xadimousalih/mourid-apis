package com.mycompany.publisherapi.service;

import com.mycompany.publisherapi.exception.BayiteNotFoundException;
import com.mycompany.publisherapi.model.Bayite;
import com.mycompany.publisherapi.repository.BayiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BayiteServiceImpl implements BayiteService {

    private final BayiteRepository bayiteRepository;

    @Override
    public Bayite validateAndGetBayiteById(String id) {
        return bayiteRepository.findById(id).orElseThrow(() -> new BayiteNotFoundException(id));
    }

    @Override
    public Page<Bayite> getBayitesByKhassida(String khassida, Pageable pageable) {
        return bayiteRepository.getBayitesByKhassida(khassida, pageable);
    }

    @Override
    public Page<Bayite> listAllBayiteByPage(Pageable pageable) {
        return bayiteRepository.findAll(pageable);
    }

    /*@Override
    public Page<Bayite> search(int numero, String bayitear,
                               String bayitefr,
                               String bayiteen,
                               String bayiteit,
                               String bayitees,
                               String bayitewo,
                               String bayitept,
                               String bayitech,
                               String khassida, Pageable pageable) {
        return bayiteRepository.findByNumeroOrBayitearOrBayitefrOrBayiteenOrBayiteitOrBayiteitOrBayiteesOrBayitewoOrBayiteptOrBayitechOrKhassidaAllIgnoreCase(numero, bayitear,
                bayitefr,
                bayiteen,
                bayiteit,
                bayitees,
                bayitewo,
                bayitept,
                bayitech,
                khassida, pageable);
    }*/

}
