package com.mycompany.producerapi.bus;

import com.mycompany.commonskhassida.avro.KhassidaEvent;
import com.mycompany.producerapi.model.Khassida;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

@Slf4j
@RequiredArgsConstructor
@Component
public class KhassidaStream {

    private final StreamBridge streamBridge;

    @Value("${spring.cloud.stream.bindings.khassida-out-0.content-type}")
    private String khassidaOutMimeType;

    public void khassidaCreated(Khassida khassida) {
        KhassidaEvent khassidaEvent = KhassidaEvent.newBuilder()
                .setId(khassida.getId())
                .setTitre(khassida.getTitre())
                .setTeunk(khassida.getTeunk())
                .setDescription(khassida.getDescription())
                .setPeriodeEcriture(khassida.getPeriodeEcriture())
                .setAuteur(khassida.getAuteur())
                .setNombreBayite(khassida.getNombreBayite())
                .setNombreBaate(khassida.getNombreBaate())
                .setNombreAraf(khassida.getNombreAraf())
                .setCategorie(khassida.getCategorie())
                .build();

        Message<KhassidaEvent> message = MessageBuilder.withPayload(khassidaEvent)
                .setHeader("partitionKey", khassidaEvent.getId().toString())
                .build();
        streamBridge.send("khassida-out-0", message, MimeType.valueOf(khassidaOutMimeType));

        log.info("KhassidaEvent with id '{}' and title '{}' sent to bus.", message.getPayload().getId(), message.getPayload().getTitre());
    }

}