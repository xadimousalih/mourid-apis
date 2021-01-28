package com.mycompany.producerapi.model;

import com.mycompany.producerapi.util.DateTimeUtil;
import lombok.Data;

import java.util.UUID;

@Data
public class Khassida {

    public Khassida() {
        this.id = UUID.randomUUID().toString();
        this.auteur = "Cheikh Ahmadou Bamba Khadimou Rassoul";
    }


    private String id;
    private String titre;
    private String teunk;
    private String description;
    private String periodeEcriture;
    private String auteur;
    private String nombreBayite;
    private String nombreBaate;
    private String nombreAraf;
    private String categorie;
}
