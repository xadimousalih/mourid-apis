package com.mycompany.categorizerservice.bus;

import com.mycompany.categorizerservice.service.CategoryService;
import com.mycompany.commonskhassida.avro.KhassidaEvent;
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
public class KhassidaStream {

    private final CategoryService categoryService;

    @Bean
    public Function<Message<KhassidaEvent>, Message<KhassidaEvent>> khassida() {
        return message -> {
            KhassidaEvent khassidaEvent = message.getPayload();
            MessageHeaders messageHeaders = message.getHeaders();
            log.info("KhassidaEvent with id '{}' and titre '{}' received from bus. topic: {}, partition: {}, offset: {}, deliveryAttempt: {}",
                    khassidaEvent.getId(),
                    khassidaEvent.getTitre(),
                    messageHeaders.get(KafkaHeaders.RECEIVED_TOPIC, String.class),
                    messageHeaders.get(KafkaHeaders.RECEIVED_PARTITION_ID, Integer.class),
                    messageHeaders.get(KafkaHeaders.OFFSET, Long.class),
                    messageHeaders.get(IntegrationMessageHeaderAccessor.DELIVERY_ATTEMPT, AtomicInteger.class));

            String category = categoryService.categorize(khassidaEvent.getTitre().toString(), khassidaEvent.getCategorie().toString());
            khassidaEvent.setCategorie(category);

            return MessageBuilder.withPayload(khassidaEvent)
                    .setHeader("partitionKey", khassidaEvent.getId().toString())
                    .build();
        };
    }

}