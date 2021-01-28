package com.mycompany.producerapi.rest;

import com.mycompany.producerapi.bus.BayiteStream;
import com.mycompany.producerapi.mapper.BayiteMapper;
import com.mycompany.producerapi.model.Bayite;
import com.mycompany.producerapi.rest.dto.CreateBayiteDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/bayites")
public class BayiteController {

    private final BayiteStream bayiteStream;
    private final BayiteMapper bayiteMapper;

    @Operation(summary = "Create Bayite")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Bayite createNew(@Valid @RequestBody CreateBayiteDto createBayiteDto) {
        Bayite bayite = bayiteMapper.toBayite(createBayiteDto);
        bayiteStream.bayiteCreated(bayite);
        return bayite;
    }

}
