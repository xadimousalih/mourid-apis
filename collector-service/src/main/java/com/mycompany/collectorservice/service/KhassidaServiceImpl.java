package com.mycompany.collectorservice.service;

import com.mycompany.collectorservice.model.Khassida;
import com.mycompany.collectorservice.repository.KhassidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KhassidaServiceImpl implements KhassidaService {

    private final KhassidaRepository khassidaRepository;

    @Override
    public Khassida createKhassida(Khassida khassida) {
        return khassidaRepository.save(khassida);
    }

}
