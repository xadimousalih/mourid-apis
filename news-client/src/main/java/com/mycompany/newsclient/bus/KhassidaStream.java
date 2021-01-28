package com.mycompany.newsclient.bus;

import com.mycompany.commonskhassida.avro.KhassidaEvent;
import com.mycompany.newsclient.client.dto.Khassida;
import com.mycompany.newsclient.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
@Component
public class KhassidaStream {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Bean
    public Consumer<Message<KhassidaEvent>> khassida() {
        return message -> {
            KhassidaEvent khassidaEvent = message.getPayload();
            MessageHeaders messageHeaders = message.getHeaders();
            log.info("KhassidaEvent with id '{}' and title '{}' received from bus. topic: {}, partition: {}, offset: {}, deliveryAttempt: {}",
                    khassidaEvent.getId(),
                    khassidaEvent.getTitre(),
                    messageHeaders.get(KafkaHeaders.RECEIVED_TOPIC, String.class),
                    messageHeaders.get(KafkaHeaders.RECEIVED_PARTITION_ID, Integer.class),
                    messageHeaders.get(KafkaHeaders.OFFSET, Long.class),
                    messageHeaders.get(IntegrationMessageHeaderAccessor.DELIVERY_ATTEMPT, AtomicInteger.class));

            simpMessagingTemplate.convertAndSend("/topic/khassida", createKhassida(khassidaEvent));
        };
    }

    private Khassida createKhassida(KhassidaEvent khassidaEvent) {
        Khassida khassida = new Khassida();
        khassida.setId(khassidaEvent.getId().toString());
        khassida.setTitre(khassidaEvent.getTitre().toString());
        khassida.setTeunk(khassidaEvent.getTeunk().toString());
        khassida.setDescription(khassidaEvent.getDescription().toString());
        khassida.setPeriodeEcriture(khassidaEvent.getPeriodeEcriture().toString());
        khassida.setAuteur(khassidaEvent.getPeriodeEcriture().toString());
        khassida.setNombreBayite(khassidaEvent.getNombreBayite().toString());
        khassida.setNombreBaate(khassidaEvent.getNombreBaate().toString());
        khassida.setNombreAraf(khassidaEvent.getNombreAraf().toString());
        return khassida;


    }

}
