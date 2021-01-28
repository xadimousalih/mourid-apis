package com.mycompany.producerapi.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateKhassidaDto {
    
    @Schema(title = "the titre of the khassida", example = "Mafatihoul Bichri")
    @NotBlank
    private String titre;

    @Schema(title = "the teunk of the khassida", example = "Innalaaha wa malaikatahoo")
    private String teunk;

    @Schema(title = "the description of the khassida", example = "This khassida is about Mafatihoul Bichri")
    private String description;

    @Schema(title = "the periodeEcriture of the khassida", example = "Aama Chehidnaa Bi Karam")
    private String periodeEcriture;

    @Schema(title = "the auteur of the khassida", example = "Cheikh Ahmadou Bamba Khadimou Rassoul")
    @NotBlank
    private String auteur;

    @Schema(title = "the nombre de bayite of the khassida", example = "50")
    private int nombreBayite;

    @Schema(title = "the nombre de baate of the khassida", example = "100")
    private int nombreBaate;

    @Schema(title = "the nombre de araf of the khassida", example = "1000")
    private int nombreAraf;

    @Schema(title = "the categorie of the khassida", example = "Madh")
    @NotBlank
    private String categorie;

}
