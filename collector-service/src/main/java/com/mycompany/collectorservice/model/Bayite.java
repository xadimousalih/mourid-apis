package com.mycompany.collectorservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "bayite")
public class Bayite {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String numero;

    @Field(type = FieldType.Text)
    private String bayitear;

    @Field(type = FieldType.Text)
    private String bayitefr;

    @Field(type = FieldType.Text)
    private String bayiteen;

    @Field(type = FieldType.Text)
    private String bayiteit;

    @Field(type = FieldType.Text)
    private String bayitees;

    @Field(type = FieldType.Text)
    private String bayitewo;

    @Field(type = FieldType.Text)
    private String bayitept;

    @Field(type = FieldType.Text)
    private String bayitech;

    @Field(type = FieldType.Text)
    private String khassida;
}
