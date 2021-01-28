package com.mycompany.publisherapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "khassida", createIndex = false)
public class Khassida {

    @Id
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
