package com.mycompany.categorizerservice.bus;

import com.mycompany.categorizerservice.service.CategoryService;
import com.mycompany.commonsbayite.avro.BayiteEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

@Slf4j
@RequiredArgsConstructor
@Component
public class BayiteStream {

    private final CategoryService categoryService;

    @Bean
    public Function<Message<BayiteEvent>, Message<BayiteEvent>> bayite() {
        return message -> {
            BayiteEvent bayiteEvent = message.getPayload();
            MessageHeaders messageHeaders = message.getHeaders();
            log.info("BayiteEvent with id '{}' and titre '{}' received from bus. topic: {}, partition: {}, offset: {}, deliveryAttempt: {}",
                    bayiteEvent.getId(),
                    bayiteEvent.getNumero(),
                    messageHeaders.get(KafkaHeaders.RECEIVED_TOPIC, String.class),
                    messageHeaders.get(KafkaHeaders.RECEIVED_PARTITION_ID, Integer.class),
                    messageHeaders.get(KafkaHeaders.OFFSET, Long.class),
                    messageHeaders.get(IntegrationMessageHeaderAccessor.DELIVERY_ATTEMPT, AtomicInteger.class));

            String category = categoryService.categorize(bayiteEvent.getNumero().toString(), bayiteEvent.getKhassida().toString());
            bayiteEvent.setKhassida(category);

            return MessageBuilder.withPayload(bayiteEvent)
                    .setHeader("partitionKey", bayiteEvent.getId().toString())
                    .build();
        };
    }

}