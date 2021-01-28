package com.mycompany.newsclient.bus;

import com.mycompany.commonsbayite.avro.BayiteEvent;
import com.mycompany.newsclient.client.dto.Bayite;
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
public class BayiteStream {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Bean
    public Consumer<Message<BayiteEvent>> bayite() {
        return message -> {
            BayiteEvent bayiteEvent = message.getPayload();
            MessageHeaders messageHeaders = message.getHeaders();
            log.info("BayiteEvent with id '{}' and title '{}' received from bus. topic: {}, partition: {}, offset: {}, deliveryAttempt: {}",
                    bayiteEvent.getId(),
                    bayiteEvent.getNumero(),
                    messageHeaders.get(KafkaHeaders.RECEIVED_TOPIC, String.class),
                    messageHeaders.get(KafkaHeaders.RECEIVED_PARTITION_ID, Integer.class),
                    messageHeaders.get(KafkaHeaders.OFFSET, Long.class),
                    messageHeaders.get(IntegrationMessageHeaderAccessor.DELIVERY_ATTEMPT, AtomicInteger.class));

            simpMessagingTemplate.convertAndSend("/topic/bayite", createBayite(bayiteEvent));
        };
    }

    private Bayite createBayite(BayiteEvent bayiteEvent) {
        Bayite bayite = new Bayite();
        bayite.setId(bayiteEvent.getId().toString());
        bayite.setNumero(bayiteEvent.getNumero().toString());
        bayite.setBayitear(bayiteEvent.getBayitear().toString());
        bayite.setBayitefr(bayiteEvent.getBayitefr().toString());
        bayite.setBayiteen(bayiteEvent.getBayiteen().toString());
        bayite.setBayiteit(bayiteEvent.getBayiteit().toString());
        bayite.setBayitees(bayiteEvent.getBayitees().toString());
        bayite.setBayitewo(bayiteEvent.getBayitewo().toString());
        bayite.setBayitech(bayiteEvent.getBayitech().toString());
        bayite.setKhassida(bayiteEvent.getKhassida().toString());
        return bayite;

    }

}
