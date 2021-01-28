package com.mycompany.publisherapi.rest;

import com.mycompany.publisherapi.model.Bayite;
import com.mycompany.publisherapi.rest.dto.SearchDto;
import com.mycompany.publisherapi.service.BayiteService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/bayites")
public class BayiteController {

    private final BayiteService bayiteService = null;

    @Operation(summary = "Get Bayite")
    @GetMapping
    public Page<Bayite> getBayite(@ParameterObject Pageable pageable) {
        return bayiteService.listAllBayiteByPage(pageable);
    }

    @Operation(summary = "Get Bayite by Id")
    @GetMapping("/{id}")
    public Bayite getBayiteById(@PathVariable String id) {
        return bayiteService.validateAndGetBayiteById(id);
    }

    @Operation(summary = "Get Bayite by Khassida")
    @GetMapping("/{khassida}")
    public Page<Bayite> getBayitesByKhassida(@PathVariable String khassida, @ParameterObject Pageable pageable) {
        return bayiteService.getBayitesByKhassida(khassida, pageable);
    }

    /* @Operation(
            summary = "Search for Bayite",
            description = "This endpoint does a query for the 'string' informed in the fields 'titre', 'teunk' , 'auteur' and 'category'")
    @PutMapping("/search")
    public Page<Bayite> searchBayite(@Valid @RequestBody SearchDto searchDto, @ParameterObject Pageable pageable) {
        return bayiteService.search(searchDto.getText(), pageable);
    }*/
    
}
