package com.mycompany.producerapi.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Bayite {

    public Bayite() {
        this.id = UUID.randomUUID().toString();
    }

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
