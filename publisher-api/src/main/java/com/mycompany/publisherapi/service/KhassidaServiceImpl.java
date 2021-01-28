package com.mycompany.publisherapi.service;

import com.mycompany.publisherapi.exception.KhassidaNotFoundException;
import com.mycompany.publisherapi.model.Khassida;
import com.mycompany.publisherapi.repository.KhassidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KhassidaServiceImpl implements KhassidaService {

    private final KhassidaRepository khassidaRepository;

    @Override
    public Khassida validateAndGetKhassidaById(String id) {
        return khassidaRepository.findById(id).orElseThrow(() -> new KhassidaNotFoundException(id));
    }

    @Override
    public Page<Khassida> listAllKhassidaByPage(Pageable pageable) {
        return khassidaRepository.findAll(pageable);
    }

    @Override
    public Page<Khassida> search(String text, Pageable pageable) {
        return khassidaRepository.findByTitreOrTeunkOrAuteurOrCategorieAllIgnoreCase(text, text, text, text, pageable);
    }

}
