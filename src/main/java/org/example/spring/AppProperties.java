package org.example.spring;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "app-config")
@Data
public class AppProperties {
    private String name;
    private String desc;
    private String version;
    private Security security;
    private Kafka kafka;

    @Data
    public static class Security{
        private String jwtSecret;
        private int expiration;
    }
    @Data
    public static class Kafka{
        private String topic;
    }

}
