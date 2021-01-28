package com.mycompany.publisherapi.service;

import com.mycompany.publisherapi.model.Khassida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KhassidaService {

    Khassida validateAndGetKhassidaById(String id);

    Page<Khassida> listAllKhassidaByPage(Pageable pageable);

    Page<Khassida> search(String text, Pageable pageable);

}
