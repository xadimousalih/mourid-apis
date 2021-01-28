package com.mycompany.producerapi.rest;

import com.mycompany.producerapi.bus.KhassidaStream;
import com.mycompany.producerapi.mapper.KhassidaMapper;
import com.mycompany.producerapi.model.Khassida;
import com.mycompany.producerapi.rest.dto.CreateKhassidaDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/khassidas")
public class KhassidaController {

    private final KhassidaStream khassidaStream;
    private final KhassidaMapper khassidaMapper;

    @Operation(summary = "Create Khassida")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Khassida createNew(@Valid @RequestBody CreateKhassidaDto createKhassidaDto) {
        Khassida khassida = khassidaMapper.toKhassida(createKhassidaDto);
        khassidaStream.khassidaCreated(khassida);
        return khassida;
    }

}
