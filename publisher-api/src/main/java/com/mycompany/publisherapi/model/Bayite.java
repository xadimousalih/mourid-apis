package com.mycompany.publisherapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "bayite", createIndex = false)
public class Bayite {

    @Id
    private String id;
    private String numero;
    private String bayitear;
    private String bayitefr;
    private String bayiteen;
    private String bayiteit;
    private String bayitees;
    private String bayitewo;
    private String bayitept;
    private String bayitech;
    private String khassida;
}
