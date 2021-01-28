package com.mycompany.publisherapi.rest;

import com.mycompany.publisherapi.model.Khassida;
import com.mycompany.publisherapi.rest.dto.SearchDto;
import com.mycompany.publisherapi.service.KhassidaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/khassidas")
public class KhassidaController {

    private final KhassidaService khassidaService = null;

    @Operation(summary = "Get Khassida")
    @GetMapping
    public Page<Khassida> getKhassida(@ParameterObject Pageable pageable) {
        return khassidaService.listAllKhassidaByPage(pageable);
    }

    @Operation(summary = "Get Khassida by Id")
    @GetMapping("/{id}")
    public Khassida getKhassidaById(@PathVariable String id) {
        return khassidaService.validateAndGetKhassidaById(id);
    }

    @Operation(
            summary = "Search for Khassida",
            description = "This endpoint does a query for the 'string' informed in the fields 'titre', 'teunk' , 'auteur' and 'category'")
    @PutMapping("/search")
    public Page<Khassida> searchKhassida(@Valid @RequestBody SearchDto searchDto, @ParameterObject Pageable pageable) {
        return khassidaService.search(searchDto.getText(), pageable);
    }

}
