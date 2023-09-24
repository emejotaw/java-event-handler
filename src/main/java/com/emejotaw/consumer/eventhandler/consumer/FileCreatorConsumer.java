package com.emejotaw.consumer.eventhandler.consumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;

@Log4j2
@Component
public class FileCreatorConsumer {

    @SqsListener(value = "aws-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void consumeMessage(
            final String message,
            @Headers final Map<String, String> headers) {

        log.info("Message received: {}", message);
    }
}
