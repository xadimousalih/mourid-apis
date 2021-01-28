package com.mycompany.producerapi.bus;

import com.mycompany.commonsbayite.avro.BayiteEvent;
import com.mycompany.producerapi.model.Bayite;
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
//Pour la gestion des bayites
public class BayiteStream {

    private final StreamBridge streamBridge;

    @Value("${spring.cloud.stream.bindings.bayite-out-0.content-type}")
    private String bayiteOutMimeType;

    public void bayiteCreated(Bayite bayite) {
        BayiteEvent bayiteEvent = BayiteEvent.newBuilder()
                .setId(bayite.getId())
                .setNumero(bayite.getNumero())
                .setBayitear(bayite.getBayitear())
                .setBayitefr(bayite.getBayitefr())
                .setBayiteen(bayite.getBayiteen())
                .setBayiteit(bayite.getBayiteit())
                .setBayitees(bayite.getBayitees())
                .setBayitewo(bayite.getBayitewo())
                .setBayitept(bayite.getBayitept())
                .setBayitech(bayite.getBayitech())
                .setKhassida(bayite.getKhassida())
                .build();

        Message<BayiteEvent> message = MessageBuilder.withPayload(bayiteEvent)
                .setHeader("partitionKey", bayiteEvent.getId().toString())
                .build();
        streamBridge.send("bayite-out-0", message, MimeType.valueOf(bayiteOutMimeType));

        log.info("BayiteEvent with id '{}' and title '{}' sent to bus.", message.getPayload().getId(), message.getPayload().getNumero());
    }

}