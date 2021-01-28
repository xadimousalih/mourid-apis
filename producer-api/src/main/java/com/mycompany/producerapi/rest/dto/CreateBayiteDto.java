package com.mycompany.producerapi.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateBayiteDto {


    @Schema(title = "the numero d'ordre du bayite", example = "4")
    @NotBlank
    private int numero;

    @Schema(title = "the bayite traduit en arabe", example = "مفاتيح السعادة")
    @NotBlank
    private String bayitear;
    
    @Schema(title = "the bayite traduit en français", example = "Les cles du bonheur")
    @NotBlank
    private String bayitefr;

    @Schema(title = "the bayite traduit en anglais", example = "The keys to happiness")
    @NotBlank
    private String bayiteen;

    @Schema(title = "the bayite traduit en italien", example = "Le chiavi della felicità")
    @NotBlank
    private String bayiteit;

    @Schema(title = "the bayite traduit en espagnol", example = "Las claves de la felicidad")
    @NotBlank
    private String bayitees;

    @Schema(title = "the bayite traduit en wolof", example = "Thiabic Mbegg")
    @NotBlank
    private String bayitewo;

    @Schema(title = "the bayite traduit en portuguais", example = "As chaves para a felicidade")
    @NotBlank
    private String bayitept;

    @Schema(title = "the bayite traduit en chinois", example = "作为狂欢")
    @NotBlank
    private String bayitech;

    @Schema(title = "the khassida of the bayite", example = "Mafaatihoul Bichri")
    @NotBlank
    private String khassida;
}
