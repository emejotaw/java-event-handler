package com.emejotaw.consumer.eventhandler.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class AwsProperties {
    @Value("${cloud.aws.endpoint}")
    private String url;
    @Value("${cloud.aws.region.static}")
    private String region;
}
