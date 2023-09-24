package com.emejotaw.consumer.eventhandler.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.emejotaw.consumer.eventhandler.configuration.properties.AwsProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@RequiredArgsConstructor
public class SQSConfiguration {

    private final AwsProperties properties;

    @Bean
    @Primary
    public AmazonSQSAsync amazonSQSAsync() {

        final AwsClientBuilder.EndpointConfiguration endpointConfiguration =
                new AwsClientBuilder.EndpointConfiguration(
                        properties.getUrl(),
                        properties.getRegion());

        final AWSCredentials credentials = new BasicAWSCredentials(
                "XXXXXXXXXXX1",
                "XXXXXXXXXXX2");

        final AmazonSQSAsync amazonSQSAsync = AmazonSQSAsyncClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withEndpointConfiguration(endpointConfiguration)
                .build();
        
        return amazonSQSAsync;
    }
}
