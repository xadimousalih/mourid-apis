package com.mycompany.collectorservice.service;

import com.mycompany.collectorservice.model.Bayite;
import com.mycompany.collectorservice.repository.BayiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BayiteServiceImpl implements BayiteService {

    private final BayiteRepository bayiteRepository;

    @Override
    public Bayite createBayite(Bayite bayite) {
        return bayiteRepository.save(bayite);
    }

}
