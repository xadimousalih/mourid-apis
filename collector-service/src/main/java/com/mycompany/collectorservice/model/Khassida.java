package com.mycompany.collectorservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "khassida")
public class Khassida {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String titre;

    @Field(type = FieldType.Text)
    private String teunk;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Text)
    private String periodeEcriture;

    @Field(type = FieldType.Text)
    private String auteur;

    @Field(type = FieldType.Text)
    private String nombreBayite;

    @Field(type = FieldType.Text)
    private String nombreBaate;

    @Field(type = FieldType.Text)
    private String nombreAraf;

    @Field(type = FieldType.Text)
    private String categorie;

}
